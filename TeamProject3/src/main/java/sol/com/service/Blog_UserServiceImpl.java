package sol.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void deleteBlog_User(Blog_User blog_User) {
		blog_UserRepo.deleteById(blog_User.getId());
		
	}

	@Override
	public Blog_User getBlog_User(Blog_User blog_User) {
		return blog_UserRepo.findById(blog_User.getId()).get();
	}
}
