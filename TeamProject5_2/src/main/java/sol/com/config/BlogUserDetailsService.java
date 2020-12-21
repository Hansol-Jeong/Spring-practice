package sol.com.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sol.com.domain.Blog_User;
import sol.com.persistence.Blog_UserRepo;

@Service
public class BlogUserDetailsService implements UserDetailsService{
	
	@Autowired
	private Blog_UserRepo userRepo;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("전달된 유저아이디 : " + username);
		// Blog_UserRepository 객체를 이용하여 User 정보를 조회한다.
		Optional<Blog_User> findUser = userRepo.findById(username);
		if(!findUser.isPresent()) {
			System.out.println("로그인 실패!");
			throw new UsernameNotFoundException(username + " 사용자가 없습니다.");
		} else {
			System.out.println("로그인 성공!");
			Blog_User user = findUser.get();
			SecurityUser su = new SecurityUser(user);
			System.out.println(su.getAuthorities());
			return su;
		}
	}
}
