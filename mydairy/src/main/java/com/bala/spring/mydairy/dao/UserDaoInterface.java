package com.bala.spring.mydairy.dao;

import java.util.List;

import com.bala.spring.mydairy.entities.User;

public interface UserDaoInterface {
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User getById(int id);
	public List<User> findAll();
	public User findByUsername(String username);

}
