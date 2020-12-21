package com.rubypaper.jdbc.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Configuration
@ConditionalOnMissingBean(JDBCConnectionManager.class)//특정객체가 메모리에 뜨도록
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {//spring.factories에 등록해서 내가만든 클래스도 자동설정 클래스로 등록

	@Autowired
	private JDBCConnectionManagerProperties dbProperties;
	@Bean
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
//		manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
//		manager.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		manager.setUsername("hr");
//		manager.setPassword("hr");
		manager.setDriverClass(dbProperties.getDriverClass());
		manager.setUrl(dbProperties.getUrl());
		manager.setUsername(dbProperties.getUsername());
		manager.setPassword(dbProperties.getPassword());
		return manager;
	}
}