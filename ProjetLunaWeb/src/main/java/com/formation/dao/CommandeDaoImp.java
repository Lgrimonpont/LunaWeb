package com.formation.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.persistence.Commande;



@Repository
public class CommandeDaoImp implements CommandeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<Commande> getAllCommande() {
		@SuppressWarnings("unchecked")
		TypedQuery<Commande> query = (TypedQuery<Commande>) (sessionFactory.getCurrentSession()).createQuery("from Commande");
		return query.getResultList();
	}
	
	@Override
	public Commande getCommande(long commandeID) {
		
		@SuppressWarnings("unchecked")
		TypedQuery<Commande> query = (TypedQuery<Commande>) (sessionFactory.getCurrentSession()).createQuery("from Commande where id ="+commandeID);
		return query.getResultList().get(0);
	}
	
	@Override
	public void insertCommande(Commande commande) {
		sessionFactory.getCurrentSession().save(commande);
	}
	
	@Override
	public void removeCommande(long commandeID) {
		@SuppressWarnings("unchecked")
		TypedQuery<Commande> query = (TypedQuery<Commande>) (sessionFactory.getCurrentSession()).createQuery("delete from Commande where id ="+commandeID);
		query.executeUpdate();
	}
	
	@Override
	public void updateCommande(Commande commande) {
		@SuppressWarnings("unchecked")
		TypedQuery<Commande> query = (TypedQuery<Commande>) (sessionFactory.getCurrentSession())
				.createQuery("UPDATE Commande SET datecommande='"+commande.getDatecommande()+"',idclient='"+commande.getIdclient()+"',libelle='"+commande.getLibelle()+"' WHERE id='"+commande.getId()+"'");
		query.executeUpdate();
	}
	}
