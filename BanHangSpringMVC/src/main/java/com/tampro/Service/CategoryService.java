package com.tampro.Service;

import java.util.List;

import com.tampro.Model.Category;

public interface CategoryService {
	
	
	public List<Category> getAllCategory() ;
	 
	 public void deleteCategory(int id);
	 
	 public void updateCategory(Category  category);
	 
	 public void addCategory(Category ategory);
	 
	 public Category getCategory(int id);

}
