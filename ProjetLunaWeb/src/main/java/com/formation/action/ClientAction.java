package com.formation.action;


import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.persistence.Client;
import com.formation.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class ClientAction extends ActionSupport implements ModelDriven<Client> {
	
	@Autowired
	private ClientService clientService;
	
	private static final long serialVersionUID = 1L;

	private Client client = new Client();
	
	@Action(value = "removeClient")
	public Client removeClient(int clientID) {
		clientService.removeClient(clientID);
		return null;
	}
	
	@Action(value = "insertClient")
	public Client insertClient(String prenom, String nom, String adresse, int codePostal, int fixe, int mobile, String email, String remarques) {
		clientService.insertClient(client);
		return null;
	}
	
	@Action(value = "updateClient")
	public Client updateClient(String prenom, String nom, String adresse, int codePostal, int fixe, int mobile, String email, String remarques) {
		clientService.updateClient(client);
		return null;
	}
	
//	@Action(value = "getClient")
//	public Client getClient(clientID) {
//		clientService.getClient(clientID);
//		return null;
//	}
//	public Client getAllClient() {
//		clientService.getAllClient();
//		return null;
//	}

	@Override
	public Client getModel() {
		return client;
	}

}
