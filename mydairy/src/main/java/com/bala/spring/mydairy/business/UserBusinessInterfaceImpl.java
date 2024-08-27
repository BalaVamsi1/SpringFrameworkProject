package com.bala.spring.mydairy.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bala.spring.mydairy.dao.UserDaoInterface;
import com.bala.spring.mydairy.entities.User;
@Component
public class UserBusinessInterfaceImpl implements UserDaoInterface, UserBusinessInterface {
	
	@Autowired
	private UserDaoInterface userDaoInterface;
	
	public UserDaoInterface getUserInterface() {
		return userDaoInterface;
	}

	public void setUserInterface(UserDaoInterface userInterface) {
		this.userDaoInterface = userInterface;
	}

	public void save(User user) {
		userDaoInterface.save(user);
	}

	public void update(User user) {
		userDaoInterface.update(user);
	}

	public void delete(User user) {
		userDaoInterface.delete(user);
	}

	public User getById(int id) {
		return userDaoInterface.getById(id);
	}

	public List<User> findAll() {
		return userDaoInterface.findAll();
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDaoInterface.findByUsername(username);
	}

}
