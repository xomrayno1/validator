package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.UserDAO;
import com.tampro.Model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<User> getAllUser() {
		String sql ="select * from user";
		return  jdbcTemplate.query(sql, new Object[] {},new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User us = new User();
				us.setIdUser(rs.getInt("id"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				us.setRole(rs.getString("role"));
		     	return us;
			}
		});
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		String sql ="update user  set username = ?,password= ?, role = ? where id = ?";
		jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getRole(),user.getIdUser());
	}

	public void addUser(User user) {
		String sql = "insert into user(username,password,role) values(?,?,?)";
		jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getRole());
		
	}

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByUsername(String username) {
		String sql = "select * from user where username = ?";
		 List<User> listus= jdbcTemplate.query(sql, new Object[] {username},new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User us = new User();
				us.setIdUser(rs.getInt("id"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				us.setRole(rs.getString("role"));
		     	return us;
			}
		});
		if(listus.isEmpty())
		{
			return null;
		}
		return listus.get(0);
	}

}
