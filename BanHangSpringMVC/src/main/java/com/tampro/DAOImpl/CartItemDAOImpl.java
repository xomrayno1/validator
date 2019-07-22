package com.tampro.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.CartItemDAO;
import com.tampro.Model.CartItem;
import com.tampro.Model.Join;

@Repository
public class CartItemDAOImpl implements CartItemDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addCartItemDAO(final CartItem cartItem) {
		// TODO Auto-generated method stub
		final String sql = "insert into cartitem(idproduct,quantity,unitPrice,date)values(?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		//jdbcTemplate.update(sql,cartItem.getProduct().getIdProduct(),cartItem.getQuantity(),cartItem.getUnitPrice());	
		 jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, cartItem.getProduct().getIdProduct());
				ps.setInt(2, cartItem.getQuantity());
				ps.setInt(3, cartItem.getUnitPrice());
				ps.setString(4,LocalDateTime.now().toString());
				return ps;
			}
		},keyHolder);
		int key = keyHolder.getKey().intValue();
		cartItem.setIdCartItem(key);
		
		
	}

	public void deleteCartItem(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Join> getList() {
		String sql = "select banhang.order.idorder,banhang.profile.name,banhang.profile.diachi, banhang.order.dateOrder,banhang.profile.sdt,banhang.cartitem.idproduct\r\n" + 
				",banhang.cartitem.quantity,banhang.cartitem.unitPrice,banhang.user.username\r\n" + 
				"from banhang.order \r\n" + 
				"inner join banhang.profile\r\n" + 
				"on banhang.order.iduser = banhang.profile.iduser\r\n" + 
				"inner join banhang.cartitem\r\n" + 
				"on banhang.order.idcartitem = banhang.cartitem.id\r\n" + 
				"inner join banhang.user\r\n" + 
				"on banhang.order.iduser = banhang.user.id";
		
		
		
		return jdbcTemplate.query(sql, new Object[] {},new RowMapper<Join>() {

			public Join mapRow(ResultSet rs, int rowNum) throws SQLException {
				Join j = new Join();
				j.setIdorder(rs.getInt("idorder"));
				j.setName(rs.getString("name"));
				j.setDiachi(rs.getString("diachi"));
				j.setDateOrder(rs.getString("dateOrder"));
				j.setSdt(rs.getString("sdt"));
				j.setIdproduct(rs.getInt("idproduct"));
				j.setQuantity(rs.getInt("quantity"));
				j.setUnitPrice(rs.getInt("unitPrice"));
				j.setUsername(rs.getString("username"));

				return j;
			}
			
		});
	}

	public void DeleteCartItem(int id) {
	  String sql = "delete from cartitem where id = ?";
	  jdbcTemplate.update(sql,id);
		
	}

}
