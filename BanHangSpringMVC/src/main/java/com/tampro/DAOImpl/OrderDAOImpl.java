package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.OrderDAO;
import com.tampro.Model.Order;

@Repository 
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO `order` ( `iduser`,`idcartitem`,`dateOrder`) VALUES (?,?,?)" ;
		
		
		
		jdbcTemplate.update(sql,order.getIdUser(),order.getIdCartItem(),LocalDateTime.now().toString());
	}

	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from `order` where `idorder` = ?";
		  jdbcTemplate.update(sql,id);
	}

	public Order getOrder(int id) {
		String sql ="select * from `order` where `idorder` = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id},new RowMapper<Order>() {

			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order od = new Order();
				od.setDateOrder(rs.getString("dateOrder"));
				od.setIdCartItem(rs.getInt("idcartitem"));
				od.setIdOrder(rs.getInt("idorder"));
				od.setIdUser(rs.getInt("iduser"));
				return od;
			}
			
		});
	}
	


}
