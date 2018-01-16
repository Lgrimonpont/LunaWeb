package com.formation.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.persistence.CommandCreer;

@Repository
public class CommandCreerDaoImp implements CommandCreerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<CommandCreer> getAllCommandCreer() {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandCreer> query = (TypedQuery<CommandCreer>) (sessionFactory.getCurrentSession()).createQuery("from Commandcreer");
		return query.getResultList();
	}
	
	@Override
	public CommandCreer getCommandCreer(int commandCreerID) {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandCreer> query = (TypedQuery<CommandCreer>) (sessionFactory.getCurrentSession()).createQuery("from Commandcreer where id ="+commandCreerID);
		return query.getResultList().get(0);
	}
	
	@Override
	public void insertCommandCreer(CommandCreer commandCreer) {
		sessionFactory.getCurrentSession().save(commandCreer);
	}
	
	@Override
	public void removeCommandCreer(int commandCreerID) {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandCreer> query = (TypedQuery<CommandCreer>) (sessionFactory.getCurrentSession()).createQuery("delete from Commandcreer where id ="+commandCreerID);
		query.executeUpdate();
	}
	
	@Override
	public void updateCommandCreer(CommandCreer commandCreer) {
		
	}
	}
