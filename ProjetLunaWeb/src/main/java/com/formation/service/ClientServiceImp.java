package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.ClientDao;
import com.formation.persistence.Client;

@Service
public class ClientServiceImp implements ClientService {

	@Autowired
	private ClientDao clientDao;

	@Transactional
	@Override
	public void insertClient(Client client) {
		clientDao.insertClient(client);
	}

	@Transactional
	@Override
	public void updateClient(Client client) {
		clientDao.updateClient(client);
	}

	@Transactional
	@Override
	public void removeClient(int clientID) {
		clientDao.removeClient(clientID);
	}

	@Transactional
	@Override
	public Client getClient(int clientID) {
		return clientDao.getClient(clientID);
	}

	@Transactional
	@Override
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}
}
