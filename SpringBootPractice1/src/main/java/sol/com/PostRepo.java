package sol.com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends JpaRepository<Post, Long>{

}
