package com.tampro.Service;

import java.util.List;

import com.tampro.Model.Product;

public interface ProductService {

	
    public List<Product> getAllProduct() ;
	 
    public List<Product> getAllProductByIdCategory(int idCategory) ;
    
    public List<Product> getAllProductByIdCategoryAndTypeProduct(int idCategory,int typeProduct) ;
    
    public List<Product> getAllProductBySearch(String name) ;
    
	 public void deleteProduct(int id);
	 
	 public void updateProduct(Product  product);
	 
	 public void addProduct(Product product);
	 
	 public Product getProductById(int id);
	 
     public int GetCountProduct();
	 
	 public List<Product> getProductNav(int frist,int last);
	 
	 public List<Product> getProductNavCateType(int idCategory, int typeProduct, int frist, int last);
}
