package com.formation.dao;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.persistence.User;


@Repository
public class UserDaoImp implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAllUser() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = (TypedQuery<User>) (sessionFactory.getCurrentSession()).createQuery("from User");
		return query.getResultList();
	}

	@Override
	public User getUser(int userID) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = (TypedQuery<User>) (sessionFactory.getCurrentSession()).createQuery("from User where id="+userID);
		return query.getResultList().get(0);
	}

	@Override
	public void insertUser(User User) {
		sessionFactory.getCurrentSession().save(User);
	}

	@Override
	public void removeUser(int userID) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = (TypedQuery<User>) (sessionFactory.getCurrentSession()).createQuery("delete from User where id="+userID);
        query.executeUpdate();
	}

	@Override
	public void updateUser(User User) {
		
	}

	@Override
	public boolean getUserConnection(String user, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}

}