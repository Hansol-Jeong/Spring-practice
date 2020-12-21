package sol.com.persistence;

import org.springframework.data.repository.CrudRepository;

import sol.com.domain.Blog;

public interface BlogRepo extends CrudRepository<Blog, Long>{

}
