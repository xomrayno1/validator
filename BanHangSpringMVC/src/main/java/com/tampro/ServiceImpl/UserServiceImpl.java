package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.UserDAO;
import com.tampro.Model.User;
import com.tampro.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;
	
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		dao.updateUser(user);
		
	}

	public void addUser(User user) {
		dao.addUser(user);
		
	}

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.getUserByUsername(username);
	}

}
