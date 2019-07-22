package com.tampro.Service;

import java.util.List;

import com.tampro.Model.View;

public interface ViewService {
	
public void addView(View view);
	
	public void deleteViewByid(int id);
	
	public void updateViewById(View view);

	public View getViewById(int  idview);
	
	public View getViewByIdProduct(int  idProduct);
	
	public List<View> getViewAll(int idProduct);
	
	public List<View> get4ViewAll();

}
