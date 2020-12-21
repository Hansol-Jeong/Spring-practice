package sol.com.persistence;

import org.springframework.data.repository.CrudRepository;

import sol.com.domain.Category;
import sol.com.domain.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long> {


}
