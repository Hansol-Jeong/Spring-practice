package sol.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sol.com.domain.Blog;
import sol.com.persistence.BlogRepo;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogRepo blogrepo;

	@Override
	public void insertBlog(Blog blog) {
		blogrepo.save(blog);
	}

	@Override
	public void deleteBlog(Blog blog) {
		blogrepo.deleteById(blog.getBlogId());
	}

	@Override
	public Blog getBlog(Blog blog) {
		return blogrepo.findById(blog.getBlogId()).get();
	}

	@Override
	public List<Blog> getBlogList(Blog blog) {
		return (List<Blog>) blogrepo.findAll();
	}



}
