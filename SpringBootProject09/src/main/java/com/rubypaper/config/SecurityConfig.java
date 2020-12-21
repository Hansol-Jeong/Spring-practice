package com.rubypaper.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		// ����Ʈ�� ��û ������ ��Ȱ��ȭ ��Ų��.
		security.csrf().disable();

		// SecurityController�� ��ϵ� ��û�� ���ؼ� ������ ������ üũ�Ѵ�.
		// index(/)�������� ������ ������� ��� ����ڰ� ��û�� �� �ִ�.
		security.authorizeRequests().antMatchers("/").permitAll();
		// member ��ο� �ִ� ���Ͽ� ���� ��û�� ������, �� �α��� ������ ����ڸ� �����ϵ���...
		security.authorizeRequests().antMatchers("/member/**").authenticated(); // ������ ����ڸ� ��� �׿� �ִ� ��� ���ҽ��� ���� ������ ��
																				// �ִ�.
		// manager ��ο� �ִ� ���Ͽ� ���� ��û�� ������ �����ϰ� ������ MANAGER�� ����ڸ� �����ϵ���...
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER"); // manager ��ο� �ִ�
		
		// admin ��ο� �ִ� ���Ͽ� ���� ��û�� ������ �����ϰ� ������ admin�� ����ڸ� �����ϵ���...
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN"); 

		// ����ڿ��� �α��� ȭ���� �����Ѵ�.
		security.formLogin().loginPage("/login");
		
	}
}
