package sol.com.service;

import java.util.List;

import sol.com.domain.Category;

public interface CategoryService {
	void insertCategory(Category category);
	List<Category> findAll();
	Category findByName(String name);
	void deleteCategory(Category category);
}
