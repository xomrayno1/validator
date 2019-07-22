package com.tampro.Model;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int idProduct;
	private int idCategory;
	private String nameProduct;
	private String urlProduct;
	private int priceProduct;
	private String describeProduct;
	private String imagesProduct;
	private int typeProduct;
	private MultipartFile multipartFile;
	private int countView;
	

	

	
	
	

	public int getcountView() {
		return countView;
	}
	public void setcountView(int view) {
		this.countView = view;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getUrlProduct() {
		return urlProduct;
	}
	public void setUrlProduct(String urlProduct) {
		this.urlProduct = urlProduct;
	}
	public int getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}
	public String getDescribeProduct() {
		return describeProduct;
	}
	public void setDescribeProduct(String describeProduct) {
		this.describeProduct = describeProduct;
	}
	public String getImagesProduct() {
		return imagesProduct;
	}
	public void setImagesProduct(String imagesProduct) {
		this.imagesProduct = imagesProduct;
	}
	public int getTypeProduct() {
		return typeProduct;
	}
	public void setTypeProduct(int typeProduct) {
		this.typeProduct = typeProduct;
	}
	
	
	
	
	
	


}
