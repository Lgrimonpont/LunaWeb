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
	private Boolean ajouter_modifier=false;

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
	
	@Action(value = "modifierClientLink", results = { @Result(name = "modifierLink", type = "tiles", location = "ajouterClient") })
	public String modifierClientLink() {
		ajouter_modifier=false;
		client=clientService.getClient(idClient);
		setListClient();
		return "modifierLink";
	}

	@Action(value = "modifierClient", results = { @Result(name = "modifier", type = "tiles", location = "client") })
	public String modifierClient() {
		System.out.println(client.getCarteFidelite());
		clientService.updateClient(client);		
		setListClient();
		return "modifier";
	}
	
	@Action(value = "ajouterClientLink", results = { @Result(name = "ajouterLink", type = "tiles", location = "ajouterClient") })
	public String ajouteClientLink() {
		ajouter_modifier=true;
		setListClient();
		return "ajouterLink";
	}
	@Action(value = "ajouterClient", results = { @Result(name = "ajouter", type = "tiles", location = "client") })
	public String ajouteClient() {
		clientService.insertClient(client);
		setListClient();
		return "ajouter";
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public Boolean getAjouter_modifier() {
		return ajouter_modifier;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
