package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.UserDao;
import com.formation.persistence.User;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
		
	}

	@Transactional
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);		
	}

	@Transactional
	@Override
	public void removeUser(long userID) {
		userDao.removeUser(userID);		
	}

	@Transactional
	@Override
	public User getUser(long userID) {
		
		return userDao.getUser(userID);
	}

	@Transactional
	@Override
	public boolean getUserConnection(String user, String passwd) {
		return userDao.getUserConnection(user, passwd);
	}

	@Transactional
	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
}
