package sol.com.service;

import java.util.List;

import sol.com.domain.Blog;

public interface BlogService {
	void insertBlog(Blog blog);
	void deleteBlog(Blog blog);
	Blog getBlog(Blog blog);
	List<Blog> getBlogList(Blog blog);
}
