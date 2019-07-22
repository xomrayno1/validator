package com.tampro.DAO;

import com.tampro.Model.Order;

public interface OrderDAO {
	
	public void addOrder(Order order);
	
	public void deleteOrder(int id);

	public Order getOrder(int id);
}
