package com.cts.springjpa.services;

import java.util.List;

import com.cts.springjpa.model.User;

public interface UserService {
	
	public User getUser(int id);
	public List<User> getAllUsers();
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id);
}
