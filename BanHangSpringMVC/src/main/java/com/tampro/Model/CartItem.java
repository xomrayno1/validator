package com.tampro.Model;

public class CartItem {
	private int idCartItem;
	private Product product; // CartItem la 1 product
	private int unitPrice;
	private int quantity;
	private String date;
	
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIdCartItem() {
		return idCartItem;
	}
	public void setIdCartItem(int idCartItem) {
		this.idCartItem = idCartItem;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	
	
	
	
	
}
