package sol.com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepo extends JpaRepository<Content, Long> {

}
