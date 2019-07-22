package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.ViewDAO;
import com.tampro.Model.View;

@Repository
public class ViewDAOImpl implements ViewDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addView(View view) {
		// TODO Auto-generated method stub
		String sql = "insert into view(idproduct,countview)values(?,?)";
		jdbcTemplate.update(sql,view.getIdProduct(),view.getCountView());
	}

	public void deleteViewByid(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateViewById(View view) {


		String sql = "update view  set idproduct= ?,countview=? where id= ? ";
		jdbcTemplate.update(sql,view.getIdProduct(),view.getCountView(),view.getIdView());
		
	}

	public View getViewById(int idview) {
		// TODO Auto-generated method stub
		return null;
	}

	public View getViewByIdProduct(int idProduct) {
		// TODO Auto-generated method stub
		String sql = "select * from view where idproduct = ?";
		
		List<View> listView= jdbcTemplate.query(sql,new Object[] {idProduct},new RowMapper<View>() {

			public View mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				View view = new View();
				view.setIdView(rs.getInt("id"));
				view.setCountView(rs.getInt("countview"));
				view.setIdProduct(rs.getInt("idproduct"));			
				return view;
			}
			
		});
		if(listView.isEmpty())
		{
			return null;
		}
		return listView.get(0);
	}

	public List<View> getViewAll(int idProduct) {
		// TODO Auto-generated method stub
		return null;
	}
	//select * from view ORDER BY countview DESC LIMIT 4;
// lay ra 4 hang trong view co countview lon nhat
	public List<View> get4ViewAll() {
		// TODO Auto-generated method stub
		String sql = "select * from view ORDER BY countview DESC LIMIT 4";
		return  jdbcTemplate.query(sql,new Object[] {},new RowMapper<View>() {

			public View mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				View view = new View();
				view.setIdView(rs.getInt("id"));
				view.setCountView(rs.getInt("countview"));
				view.setIdProduct(rs.getInt("idproduct"));			
				return view;
			}
			
		});

	}
	
	
	
    
	
	

	
	
	
	

}
