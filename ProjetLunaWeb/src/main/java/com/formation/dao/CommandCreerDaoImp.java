package com.formation.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.persistence.CommandCreer;

@Repository
public class CommandCreerDaoImp implements CommandCreerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<CommandCreer> getAllCommandCreer() {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandCreer> query = (TypedQuery<CommandCreer>) (sessionFactory.getCurrentSession()).createQuery("from Commandcreer");
		return query.getResultList();
	}
	
	@Override
	public CommandCreer getCommandCreer(int commandcreerID) {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandCreer> query = (TypedQuery<CommandCreer>) (sessionFactory.getCurrentSession()).createQuery("from Commandcreer where id ="+commandcreerID);
		return query.getResultList().get(0);
	}
	
	@Override
	public void insertCommandCreer(CommandCreer commandcreer) {
		sessionFactory.getCurrentSession().save(commandcreer);
	}
	
	@Override
	public void removeCommandCreer(int commandcreerID) {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandCreer> query = (TypedQuery<CommandCreer>) (sessionFactory.getCurrentSession()).createQuery("delete from Commandcreer where id ="+commandcreerID);
		query.executeUpdate();
	}
	
	@Override
	public void updateCommandCreer(CommandCreer commandcreer) {
		
	}
	}
