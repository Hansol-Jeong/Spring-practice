/*package com.hanwoo.securityConfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hanwoo.domain.Blog_User;
import com.hanwoo.persistence.Blog_UserRepository;

@Service
public class Blog_UserDetailsService implements UserDetailsService {
	@Autowired
	private Blog_UserRepository blog_UserRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Blog_User> findBlog_User = blog_UserRepository.findById(username);
		if(!findBlog_User.isPresent()) {
			throw new UsernameNotFoundException(username+"사용자가 없네요");
		} else {
			Blog_User blog_User = findBlog_User.get();
			return new SecurityUser(blog_User);
		}

	}
	
}



*/




