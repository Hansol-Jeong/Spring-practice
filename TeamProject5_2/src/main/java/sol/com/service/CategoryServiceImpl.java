package sol.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sol.com.domain.Category;
import sol.com.persistence.CategoryRepo;
@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryRepo categoryRepo;
	@Override
	public void insertCategory(Category category) {
		categoryRepo.save(category);
	}
	@Override
	public List<Category> findAll() {
		return (List<Category>) categoryRepo.findAll();
	}
	@Override
	public Category findByName(String name) {
		return categoryRepo.findBycategoryName(name);
	}
	@Override
	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
	}
	

}
