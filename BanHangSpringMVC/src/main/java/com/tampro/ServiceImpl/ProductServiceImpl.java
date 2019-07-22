package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.ProductDAO;
import com.tampro.Model.Product;
import com.tampro.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDao;
	
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
		
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.addProduct(product);
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}

	public List<Product> getAllProductByIdCategory(int idCategory) {
		// TODO Auto-generated method stub
		return productDao.getAllProductByIdCategory(idCategory);
	}

	public List<Product> getAllProductByIdCategoryAndTypeProduct(int idCategory, int typeProduct) {
		// TODO Auto-generated method stub
		return productDao.getAllProductByIdCategoryAndTypeProduct(idCategory, typeProduct);
	}

	public List<Product> getAllProductBySearch(String name) {
		// TODO Auto-generated method stub
		return productDao.getAllProductBySearch(name);
	}

	public int GetCountProduct(int idCategory, int type) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Product> getProductNav(int idCategory, int typeProduct, int frist, int last) {
		// TODO Auto-generated method stub
		return null;
	}

	public int GetCountProduct() {
		// TODO Auto-generated method stub
		return productDao.GetCountProduct();
	}

	public List<Product> getProductNav(int frist, int last) {
		// TODO Auto-generated method stub
		return productDao.getProductNav(frist, last);
	}

	public List<Product> getProductNavCateType(int idCategory, int typeProduct, int frist, int last) {
		// TODO Auto-generated method stub
		return productDao.getProductNavCateType(idCategory, typeProduct, frist, last);
	}

	
}
