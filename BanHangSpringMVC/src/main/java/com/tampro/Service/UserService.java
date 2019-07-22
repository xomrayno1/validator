package com.tampro.Service;

import java.util.List;

import com.tampro.Model.User;

public interface UserService {

	
	public List<User> getAllUser() ;
	 
	 public void deleteUser(int id);
	 
	 public void updateUser(User  user);
	 
	 public void addUser(User user);
	 
	 public User getUser(int id);
	 
	 public User getUserByUsername(String username);
	
}
