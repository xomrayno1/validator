package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.ViewDAO;
import com.tampro.Model.View;
import com.tampro.Service.ViewService;

@Service
public class ViewServiceImpl implements ViewService{
	
	@Autowired
	ViewDAO dao;

	public void addView(View view) {
		// TODO Auto-generated method stub
		dao.addView(view);
	}

	public void deleteViewByid(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateViewById(View view) {
		// TODO Auto-generated method stub
		dao.updateViewById(view);
	}

	public View getViewById(int idview) {
		// TODO Auto-generated method stub
		return null;
	}

	public View getViewByIdProduct(int idProduct) {
		// TODO Auto-generated method stub
		return dao.getViewByIdProduct(idProduct);
	}

	public List<View> getViewAll(int idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<View> get4ViewAll() {
		// TODO Auto-generated method stub
		return dao.get4ViewAll();
	}

}
