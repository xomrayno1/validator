package com.tampro.Service;

import com.tampro.Model.Order;

public interface OrderService {
	
	
    public void addOrder(Order order);
	
	public void deleteOrder(int id);
	
	
	public Order getOrder(int id);

}
