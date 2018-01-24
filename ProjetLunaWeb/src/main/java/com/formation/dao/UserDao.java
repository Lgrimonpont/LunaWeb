package com.formation.dao;

import java.util.List;

import com.formation.persistence.User;


public interface UserDao {
	public void insertUser(User user);

	public void updateUser(User user);

	public void removeUser(long userID);

	public User getUser(long userID);

	public boolean getUserConnection(String user, String passwd);

	public List<User> getAllUser();
}
