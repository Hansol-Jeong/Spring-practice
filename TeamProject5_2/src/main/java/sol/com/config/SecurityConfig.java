package sol.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BlogUserDetailsService userDetailseService;	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		// 사이트간 요청 위조를 비활성화 시킨다.
		security.csrf().disable();
		
		// SecurityCongroller에 등록된 요청에 대해서 인증과 권한을 체크한다.
		// index(/) 페이지는 인증에 상관없이 모든 사용자가 요청할 수 있다.
		security.authorizeRequests().antMatchers("/").permitAll();
		security.authorizeRequests().antMatchers("/blogadmin_basic").authenticated();
		security.authorizeRequests().antMatchers("/blogadmin_category").authenticated();
		security.authorizeRequests().antMatchers("/blogadmin_write").authenticated();
		security.authorizeRequests().antMatchers("/blogcreate.do").authenticated();
		security.authorizeRequests().antMatchers("/blogmain_detail.do").authenticated();
		security.authorizeRequests().antMatchers("/blogadmin_request_remove").hasRole("ADMIN");
		
		// 사용자에게 로그인 화면을 제공한다.
		security.formLogin().loginPage("/login").defaultSuccessUrl("/blogsystem_search.do", true);
		// 권한이 없는 페이지 접근 했을 때 보여줄 화면을 지정한다.
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		
		// 로그아웃(/logout) 요청이 들어 왔을 때, 세션을 강제 종료하고 로그인 화면으로 이동하도록 한다.
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/blogsystem_search.do");
				
		// 작성한 BlogUserDetailService 객체를 시큐리티가 인지하도록 UserDetailsService 객체로 등록한다.
		security.userDetailsService(userDetailseService);		
	}

}