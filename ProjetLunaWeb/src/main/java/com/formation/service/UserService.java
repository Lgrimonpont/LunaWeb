package com.formation.service;

import java.util.List;

import com.formation.persistence.User;

public interface UserService {
	public void insertUser(User user);

	public void updateUser(User user);

	public void removeUser(long userID);

	public User getUser(long userID);

	public boolean getUserConnection(String user, String passwd);

	public List<User> getAllUser();
}
