package com.formation.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.persistence.CommandeCreer;

@Repository
public class CommandeCreerDaoImp implements CommandeCreerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<CommandeCreer> getAllCommandeCreer() {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandeCreer> query = (TypedQuery<CommandeCreer>) (sessionFactory.getCurrentSession()).createQuery("from Commandecreer");
		return query.getResultList();
	}
	
	@Override
	public CommandeCreer getCommandeCreer(long commandeCreerID) {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandeCreer> query = (TypedQuery<CommandeCreer>) (sessionFactory.getCurrentSession()).createQuery("from Commandecreer where id ="+commandeCreerID);
		return query.getResultList().get(0);
	}
	
	@Override
	public void insertCommandeCreer(CommandeCreer commandeCreer) {
		sessionFactory.getCurrentSession().save(commandeCreer);
	}
	
	@Override
	public void removeCommandeCreer(long commandeCreerID) {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandeCreer> query = (TypedQuery<CommandeCreer>) (sessionFactory.getCurrentSession()).createQuery("delete from Commandecreer where id ="+commandeCreerID);
		query.executeUpdate();
	}
	
	@Override
	public void updateCommandeCreer(CommandeCreer commandeCreer) {
		@SuppressWarnings("unchecked")
		TypedQuery<CommandeCreer> query = (TypedQuery<CommandeCreer>) (sessionFactory.getCurrentSession())
				.createQuery("UPDATE CommandCreer SET idcommande='"+commandeCreer.getIdcommande()+"',idArticle='"+commandeCreer.getIdArticle()+"',quantite='"+commandeCreer.getQuantite()+"' WHERE id='"+commandeCreer.getId()+"'");
		query.executeUpdate();
	}
	}
