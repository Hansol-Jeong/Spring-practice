/*package com.hanwoo.securityConfig;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.hanwoo.domain.Blog_User;

public class SecurityUser extends User {

	private static final long serialVersionUID = 1L;
	
	public SecurityUser(Blog_User blog_User) {
		// 아이디, 비밀번호(암호화하지 않은), 권한을 부모 생성자쪽에 전달한다.
		super(blog_User.getUser_id(), 
				blog_User.getPassword(), 
		     AuthorityUtils.createAuthorityList(blog_User.getRole().toString()));
	}
}
*/