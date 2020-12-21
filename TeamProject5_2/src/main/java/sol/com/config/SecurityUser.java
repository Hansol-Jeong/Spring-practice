package sol.com.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import sol.com.domain.Blog_User;

public class SecurityUser extends User{
	
	private static final long serialVersionUID = 1L;

	public SecurityUser(Blog_User user) {
		super(user.getUserId(), user.getUserPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		System.out.println("로그인객체생성완료!");
	}
}
