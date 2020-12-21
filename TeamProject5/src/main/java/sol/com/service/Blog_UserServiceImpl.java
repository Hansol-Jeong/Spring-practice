package sol.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sol.com.domain.Blog;
import sol.com.domain.Blog_User;
import sol.com.persistence.Blog_UserRepo;

@Service
public class Blog_UserServiceImpl implements Blog_UserService {
	@Autowired
	private Blog_UserRepo blog_UserRepo;

	@Override
	public void insertBlog_User(Blog_User blog_User) {
		blog_UserRepo.save(blog_User);
	}
	@Override
	public Blog_User getBlog_User(Blog_User blog_User) {
		return blog_UserRepo.findById(blog_User.getUserId()).get();
	}
	@Override
	public Blog_User findByName(String name) {

		return blog_UserRepo.findByName(name);
	}
	@Override
	public Blog_User findByuserId(String id) {
		return blog_UserRepo.findByuserId(id);
	}



	
}
