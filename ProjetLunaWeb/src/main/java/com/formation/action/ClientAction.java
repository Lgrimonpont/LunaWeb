package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.persistence.Client;
import com.formation.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace(value = "/")
public class ClientAction extends ActionSupport implements ModelDriven<Client> {

	@Autowired
	private ClientService clientService;

	private static final long serialVersionUID = 1L;

	private Client client = new Client();
	private List<Client> listClient = null;
	private long idClient;

	@Override
	public Client getModel() {
		return client;
	}

	public void setListClient() {
		listClient = clientService.getAllClient();
	}

	public List<Client> getListClient() {
		return listClient;
	}

	@Action(value = "afficheClient", results = { @Result(name = "client", type = "tiles", location = "client") })
	public String afficheClient() {
		setListClient();
		return "client";
	}
	
	@Action(value = "supprimerClient", results = { @Result(name = "supprimer", type = "tiles", location = "client") })
	public String supprimer() {
		System.out.println(idClient);
		clientService.removeClient(idClient);
		setListClient();
		return "supprimer";
	}
	
	/*@Action(value = "modifierClient", results = { @Result(name = "modifier", type = "tiles", location = "modifier") })
	public String modifier() {
		setListClient();
		return "modifier";
	}*/

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

}
