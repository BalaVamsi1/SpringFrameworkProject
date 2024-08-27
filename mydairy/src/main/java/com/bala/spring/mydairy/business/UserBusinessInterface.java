package com.bala.spring.mydairy.business;

import java.util.List;

import com.bala.spring.mydairy.entities.User;

public interface UserBusinessInterface {
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User getById(int id);
	public List<User> findAll();
	public User findByUsername(String username);
}
