package com.formation.service;

import java.util.List;

import com.formation.persistence.Client;

public interface ClientService {
	public void insertClient(Client client);

	public void updateClient(Client client);

	public void removeClient(long idClient);

	public Client getClient(long clientID);

	public List<Client> getAllClient();

}
