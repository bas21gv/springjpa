package com.cts.springjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.springjpa.model.User;
import com.cts.springjpa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUser(int id) {
		return userRepository.getById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAll();
	}

	@Override
	public int addUser(User user) {
		return userRepository.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userRepository.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		return userRepository.deleteUser(id);
	}

}
