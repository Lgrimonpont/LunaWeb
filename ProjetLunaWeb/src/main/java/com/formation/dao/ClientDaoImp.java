package com.formation.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.persistence.Client;

@Repository
public class ClientDaoImp implements ClientDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Client> getAllClient() {
		@SuppressWarnings("unchecked")
		TypedQuery<Client> query = (TypedQuery<Client>) (sessionFactory.getCurrentSession()).createQuery("from Client");
		return query.getResultList();
	}

	@Override
	public Client getClient(long clientID) {
		@SuppressWarnings("unchecked")
		TypedQuery<Client> query = (TypedQuery<Client>) (sessionFactory.getCurrentSession()).createQuery("from Client where id="+clientID);
		return query.getResultList().get(0);
	}

	@Override
	public void insertClient(Client client) {
		sessionFactory.getCurrentSession().save(client);
	}

	@Override
	public void removeClient(long clientID) {
		@SuppressWarnings("unchecked")
		TypedQuery<Client> query = (TypedQuery<Client>) (sessionFactory.getCurrentSession()).createQuery("delete from Client where id="+clientID);
        query.executeUpdate();
	}

	@Override
	public void updateClient(Client client) {
		@SuppressWarnings("unchecked")
		TypedQuery<Client> query = (TypedQuery<Client>) (sessionFactory.getCurrentSession())
				.createQuery("UPDATE Client SET adresse='"+client.getAdresse()+"',cartedefidelite='"+client.getCarteFidelite()+"',codePostal='"+client.getCodePostal()+"',dateCreation='"+client.getDateCreation()+"',email='"+client.getEmail()+"',fixe='"+client.getFixe()+"',mobile ='"+client.getMobile()+"',nom='"+client.getNom()+"',prenom='"+client.getPrenom()+"',remarques='"+client.getRemarques()+"' WHERE id='"+client.getId()+"'");
		query.executeUpdate();
	}

}
