package sol.com.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sol.com.domain.Blog;

public interface BlogRepo extends CrudRepository<Blog, Long>{
	List<Blog> findByblogTitleContaining(String searchKeyword);
	   List<Blog> findBystatus(String status);
	   List<Blog> findByblogTagContaining(String blogTag);
}
