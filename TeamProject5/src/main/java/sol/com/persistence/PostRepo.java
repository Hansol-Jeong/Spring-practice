package sol.com.persistence;

import org.springframework.data.repository.CrudRepository;

import sol.com.domain.Post;

public interface PostRepo extends CrudRepository<Post, Long>{
	Post findBypostId(Long id);

}
