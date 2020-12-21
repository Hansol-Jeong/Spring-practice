package sol.com.persistence;

import org.springframework.data.repository.CrudRepository;

import sol.com.domain.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{
	Category findBycategoryName(String name);
}
