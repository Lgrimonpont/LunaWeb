package com.formation.dao;

import java.util.List;

import com.formation.persistence.User;


public interface UserDAO {
	public void insertUser(User user);
	public void updateUser(User user);
	public void removeUser(int userID);
	public User getUser(int userID);
	public boolean getUserConnection(String user, String passwd);
	public List<User> getAllUser();
}
