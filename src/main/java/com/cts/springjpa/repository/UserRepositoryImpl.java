package com.cts.springjpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.springjpa.model.User;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User getById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getAll() {
		return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	@Override
	public int addUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user.getId();
	}

	@Override
	public int updateUser(User user) {
		entityManager.merge(user);
		return 1;
	}

	@Override
	public int deleteUser(int id) {
		User user = entityManager.find(User.class, id);
		if(user == null){
			return 0;
		}
		entityManager.remove(user);
		return 1;
	}

}
