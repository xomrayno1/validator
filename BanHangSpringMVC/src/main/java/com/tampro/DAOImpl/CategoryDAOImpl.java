package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sun.rowset.internal.Row;
import com.tampro.DAO.CategoryDAO;
import com.tampro.Model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Category> getAllCategory() {
		String sql = "select * from category";

		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Category>()  {
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				Category ct = new Category();
				ct.setIdCategory(rs.getInt("id"));
				ct.setNameCategory(rs.getString("nameCategory"));

				return ct;
			}
			
		});
				
	}

	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	public void addCategory(Category ategory) {
		// TODO Auto-generated method stub
		
	}

	public Category getCategory(int id) {
		
		String sql = "select * from category where id = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Category>()  {
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				Category ct = new Category();
				ct.setIdCategory(rs.getInt("id"));
				ct.setNameCategory(rs.getString("nameCategory"));

				return ct;
			}
			
		});
		
	}
	

}
