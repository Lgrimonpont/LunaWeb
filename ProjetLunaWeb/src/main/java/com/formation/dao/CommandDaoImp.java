package com.formation.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.persistence.Command;



@Repository
public class CommandDaoImp implements CommandDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<Command> getAllCommand() {
		@SuppressWarnings("unchecked")
		TypedQuery<Command> query = (TypedQuery<Command>) (sessionFactory.getCurrentSession()).createQuery("from Command");
		return query.getResultList();
	}
	
	@Override
	public Command getCommand(int commandID) {
		
		@SuppressWarnings("unchecked")
		TypedQuery<Command> query = (TypedQuery<Command>) (sessionFactory.getCurrentSession()).createQuery("from Command where id ="+commandID);
		return query.getResultList().get(0);
	}
	
	@Override
	public void insertCommand(Command command) {
		sessionFactory.getCurrentSession().save(command);
	}
	
	@Override
	public void removeCommand(int commandID) {
		@SuppressWarnings("unchecked")
		TypedQuery<Command> query = (TypedQuery<Command>) (sessionFactory.getCurrentSession()).createQuery("delete from Command where id ="+commandID);
		query.executeUpdate();
	}
	
	@Override
	public void updateCommand(Command command) {
		@SuppressWarnings("unchecked")
		TypedQuery<Command> query = (TypedQuery<Command>) (sessionFactory.getCurrentSession())
				.createQuery("UPDATE Command SET datecommand='"+command.getDatecommand()+"',idclient='"+command.getIdclient()+"',libelle='"+command.getLibelle()+"' WHERE id='"+command.getId()+"'");
		query.executeUpdate();
	}
	}
