package com.tampro.Model;

public class Order {
	private int idOrder;
	private int idCartItem;
	private int idUser;
	private String dateOrder;
	
	
	
	
	public String getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	
	public int getIdCartItem() {
		return idCartItem;
	}
	public void setIdCartItem(int idCartItem) {
		this.idCartItem = idCartItem;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	

}
