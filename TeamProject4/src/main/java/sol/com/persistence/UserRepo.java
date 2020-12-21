package sol.com.persistence;

import org.springframework.data.repository.CrudRepository;

import sol.com.domain.User;

public interface UserRepo extends CrudRepository<User, String>{

}
