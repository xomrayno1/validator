package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.CartItemDAO;
import com.tampro.Model.CartItem;
import com.tampro.Model.Join;
import com.tampro.Service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	CartItemDAO cartItemDAO;
	
	public void addCartItemDAO(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDAO.addCartItemDAO(cartItem);
	}

	public void deleteCartItem(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Join> getList() {
		// TODO Auto-generated method stub
		return cartItemDAO.getList();
	}

	public void DeleteCartItem(int id) {
		cartItemDAO.DeleteCartItem(id);
		
	}

}
