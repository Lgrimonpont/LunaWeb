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
	public Client getClient(int clientID) {
		@SuppressWarnings("unchecked")
		TypedQuery<Client> query = (TypedQuery<Client>) (sessionFactory.getCurrentSession()).createQuery("from Client where id="+clientID);
		return query.getResultList().get(0);
	}

	@Override
	public void insertClient(Client Client) {
		sessionFactory.getCurrentSession().save(Client);
	}

	@Override
	public void removeClient(int clientID) {
		@SuppressWarnings("unchecked")
		TypedQuery<Client> query = (TypedQuery<Client>) (sessionFactory.getCurrentSession()).createQuery("delete from Client where id="+clientID);
        query.executeUpdate();
	}

	@Override
	public void updateClient(Client Client) {
		
	}

}
