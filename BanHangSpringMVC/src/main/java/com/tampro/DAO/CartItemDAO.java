package com.tampro.DAO;

import java.util.List;

import com.tampro.Model.CartItem;
import com.tampro.Model.Join;

public interface CartItemDAO {
	
	public void addCartItemDAO(CartItem cartItem);
	
	
	public void deleteCartItem(int id);
	
	public List<Join> getList();
	
	public void DeleteCartItem(int id);
	
	

}
