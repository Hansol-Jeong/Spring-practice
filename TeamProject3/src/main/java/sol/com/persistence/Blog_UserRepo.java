package sol.com.persistence;

import org.springframework.data.repository.CrudRepository;

import sol.com.domain.Blog_User;

public interface Blog_UserRepo extends CrudRepository<Blog_User, String>{

}
