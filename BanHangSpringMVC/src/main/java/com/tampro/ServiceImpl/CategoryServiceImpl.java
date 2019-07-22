package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.CategoryDAO;
import com.tampro.Model.Category;
import com.tampro.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO catedao;
	
	
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return catedao.getAllCategory();
	}

	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	public void addCategory(Category ategory) {
		// TODO Auto-generated method stub
		
	}

	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		return catedao.getCategory(id);
	}

}
