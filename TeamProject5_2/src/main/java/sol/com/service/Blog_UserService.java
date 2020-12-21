package sol.com.service;

import sol.com.domain.Blog_User;

public interface Blog_UserService {
	void insertBlog_User(Blog_User blog_User);
	Blog_User getBlog_User(Blog_User blog_User);
	Blog_User findByName(String name);
	Blog_User findByuserId(String id);
	void deleteBlog_User(Blog_User blog_User);
}
