package sol.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sol.com.domain.Blog;
import sol.com.persistence.BlogRepo;
@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogRepo blogRepo;

	@Override
	   public void insertBlog(Blog blog) {
	      blogRepo.save(blog);
	   }

	   @Override
	   public List<Blog> findByBlogTitle(String searchKeyword) {
	      return blogRepo.findByblogTitleContaining(searchKeyword);
	   }

	   @Override
	   public List<Blog> findBystatus(String status) {
	      return blogRepo.findBystatus(status);
	   }

	   @Override
	   public List<Blog> findAll() {
	      return    (List<Blog>) blogRepo.findAll();
	   }

	   @Override
	   public List<Blog> findByTag(String blogTag) {
	      return blogRepo.findByblogTagContaining(blogTag);
	   }
	
}
