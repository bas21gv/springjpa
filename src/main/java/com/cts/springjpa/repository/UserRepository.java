package com.cts.springjpa.repository;

import java.util.List;

import com.cts.springjpa.model.User;

public interface UserRepository {

	public User getById(int id);
	public List<User> getAll();
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id); 
}
