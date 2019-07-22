package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.ProductDAO;
import com.tampro.Model.Product;

@Repository
public class ProductDAOImpl  implements ProductDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Product> getAllProduct() {

		String sql = "select * from product";

		return jdbcTemplate.query(sql, new Object[] {},new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product product = new Product();
				product.setIdProduct(rs.getInt("id"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setDescribeProduct(rs.getString("describeProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setTypeProduct(rs.getInt("typeProduct"));
			
				return product;
			}
			
		});
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "delete  from product where id = ?";
		jdbcTemplate.update(sql, id);
		
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		String sql = "update product set idCategory= ?,nameProduct=?,priceProduct=?,describeProduct=?,imagesProduct=?,typeProduct=?,urlProduct=?";
		jdbcTemplate.update(sql,product.getIdCategory(),product.getNameProduct(),product.getPriceProduct(),product.getDescribeProduct()
				,product.getImagesProduct(),product.getTypeProduct(),product.getUrlProduct());
	}
	public void addProduct(Product product) {
		
		String sql = "insert into product(idCategory,nameProduct,priceProduct,describeProduct,imagesProduct,typeProduct,urlProduct) values(?,?,?,?,?,?,?)";
		// TODO Auto-generated method stub
		jdbcTemplate.update(sql,product.getIdCategory(),product.getNameProduct(),product.getPriceProduct(),product.getDescribeProduct()
				,product.getImagesProduct(),product.getTypeProduct(),product.getUrlProduct());
	}

	public Product getProductById(int id) {
		String sql = "select * from product where id = ? ";
	
		return jdbcTemplate.queryForObject(sql, new Object[] {id},new RowMapper<Product>(){

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("id"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setDescribeProduct(rs.getString("describeProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setTypeProduct(rs.getInt("typeProduct"));
				
				return product;
			}
			
		});
	}
	

	public List<Product> getAllProductByIdCategory(int idCategory) {
   
		String sql = "select * from product where idCategory = ? ";
		
		return jdbcTemplate.query(sql,new Object[] {idCategory},new RowMapper<Product>(){

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("id"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setDescribeProduct(rs.getString("describeProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setTypeProduct(rs.getInt("typeProduct"));
				
				return product;
			}
			
		});
	}

	public List<Product> getAllProductByIdCategoryAndTypeProduct(int idCategory, int typeProduct) {


		
       String sql = "select * from product where idCategory = ? and typeProduct= ?";
		
		return jdbcTemplate.query(sql,new Object[] {idCategory,typeProduct},new RowMapper<Product>(){

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("id"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setDescribeProduct(rs.getString("describeProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setTypeProduct(rs.getInt("typeProduct"));
			
				
				return product;
			}
			
		});
	}

	public List<Product> getAllProductBySearch(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from product where nameProduct LIKE '%"+name+"%'";
		
		
		return jdbcTemplate.query(sql,new Object[] {},new RowMapper<Product>(){

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("id"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setDescribeProduct(rs.getString("describeProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setTypeProduct(rs.getInt("typeProduct"));
				
		
				return product;
			}
			
		});
	}

	public int GetCountProduct() {
	
		String sql = "select count(id) from product; ";
		
		int count =  jdbcTemplate.queryForObject(sql, new Object[] {},Integer.class); // lay gia tri int
	
		return count;
	}

	public List<Product> getProductNavCateType(int idCategory, int typeProduct, int frist, int last) {
		// TODO Auto-generated method stub
		String sql = "select * from product where idCategory = ?  and typeProduct = ?  limit  ?, ?  ";
		
		return jdbcTemplate.query(sql,new Object[] {idCategory,typeProduct,frist,last},new RowMapper<Product>(){

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("id"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setDescribeProduct(rs.getString("describeProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setTypeProduct(rs.getInt("typeProduct"));
			
				
				return product;
			}
			
		});
	}
	public List<Product> getProductNav( int frist, int last) {
		// TODO Auto-generated method stub
		String sql = "select * from product   limit  ?, ?  ";
		
		return jdbcTemplate.query(sql,new Object[] {frist,last},new RowMapper<Product>(){

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setIdProduct(rs.getInt("id"));
				product.setIdCategory(rs.getInt("idCategory"));
				product.setDescribeProduct(rs.getString("describeProduct"));
				product.setImagesProduct(rs.getString("imagesProduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setUrlProduct(rs.getString("urlProduct"));
				product.setPriceProduct(rs.getInt("priceProduct"));
				product.setTypeProduct(rs.getInt("typeProduct"));
			
				
				return product;
			}
			
		});
	}



	
	
	

}
