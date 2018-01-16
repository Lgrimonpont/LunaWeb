package com.formation.dao;

import java.util.List;

import com.formation.persistence.Client;

public interface ClientDao {
	public void insertClient(Client client);

	public void updateClient(Client client);

	public void removeClient(int clientID);

	public Client getClient(int clientID);

	public List<Client> getAllClient();
}
