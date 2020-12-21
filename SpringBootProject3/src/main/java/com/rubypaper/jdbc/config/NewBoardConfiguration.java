package com.rubypaper.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

/*@Configuration
public class NewBoardConfiguration {
	@Bean//기존의 객체를 오버라이딩하면 성능상의 문제가 있기 때문에 쓰지 않는다.
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("org.h2.Driver");
		manager.setUrl("jdbc:h2:tcp://localhost/~/test");
		manager.setUsername("sa");
		manager.setPassword("");
		return manager;
	}
}*/
