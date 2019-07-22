package com.tampro.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.OrderDAO;
import com.tampro.Model.Order;
import com.tampro.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	OrderDAO orderDAO;
	
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orderDAO.addOrder(order);
	}

	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		orderDAO.deleteOrder(id);
	}

	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return orderDAO.getOrder(id);
	}

}
