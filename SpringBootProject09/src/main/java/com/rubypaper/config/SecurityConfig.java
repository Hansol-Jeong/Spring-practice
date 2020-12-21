package com.rubypaper.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		// 사이트간 요청 위조를 비활성화 시킨다.
		security.csrf().disable();

		// SecurityController에 등록된 요청에 대해서 인증과 권한을 체크한다.
		// index(/)페이지는 인증에 상관없이 모든 사용자가 요청할 수 있다.
		security.authorizeRequests().antMatchers("/").permitAll();
		// member 경로에 있는 파일에 대한 요청은 인증된, 즉 로그인 성공한 사용자만 접근하도록...
		security.authorizeRequests().antMatchers("/member/**").authenticated(); // 인증된 사용자만 멤버 및에 있는 모든 리소스에 대한 제한할 수
																				// 있다.
		// manager 경로에 있는 파일에 대한 요청은 인증에 성공하고 권한이 MANAGER인 사용자만 접근하도록...
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER"); // manager 경로에 있는
		
		// admin 경로에 있는 파일에 대한 요청은 인증에 성공하고 권한이 admin인 사용자만 접근하도록...
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN"); 

		// 사용자에게 로그인 화면을 제공한다.
		security.formLogin().loginPage("/login");
		
	}
}
