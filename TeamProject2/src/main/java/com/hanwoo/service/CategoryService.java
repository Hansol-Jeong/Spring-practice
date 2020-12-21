package com.hanwoo.service;

import java.util.List;

import com.hanwoo.domain.Category;

public interface CategoryService {
	void insertCategory(Category category);
	void deleteCategory(Category category);
	void updateCategory(Category category);
	Category getCategory(Category category);
	List<Category> getCategoryList(Category category);
}
