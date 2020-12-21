package com.hanwoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hanwoo.domain.Category;
import com.hanwoo.persistence.CategoryRepository;

public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	public void insertCategory(Category category) {
		categoryRepository.save(category);
	}

	public void deleteCategory(Category category) {
		categoryRepository.deleteById(category.getBlog_id());
	}

	public void updateCategory(Category category) {
		Category findCategory = categoryRepository.findById(category.getCATEGORY_ID()).get();
		findCategory.setCATEGORY_NAME(category.getCATEGORY_NAME());
		findCategory.setDISPLAY_TYPE(category.getDISPLAY_TYPE());
		findCategory.setCNT_DISPLAY_POS(category.getCNT_DISPLAY_POS());
		findCategory.setDESCRIPTION(category.getDESCRIPTION());
		categoryRepository.save(findCategory);
	}

	public Category getCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> getCategoryList(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
