package sol.com.service;


import java.util.List;

import sol.com.domain.Blog;

public interface BlogService {
	void insertBlog(Blog blog);
	   
	   List<Blog> findByBlogTitle(String searchKeyword);
	   List<Blog> findBystatus(String status);
	   List<Blog> findByTag(String blogTag);
	   List<Blog> findAll();
}
