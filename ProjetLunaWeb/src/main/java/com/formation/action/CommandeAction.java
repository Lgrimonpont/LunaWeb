package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;


import com.formation.persistence.Commande;
import com.formation.service.CommandeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommandeAction extends ActionSupport implements ModelDriven<Commande> {
	
	@Autowired
	private CommandeService commandeService;
	
	private static final long serialVersionUID = 1L;
	
	private Commande commande = new Commande();
	
	@Action(value = "removeCommande")
	public Commande removeCommande(int commandeID) {
		commandeService.removeCommande(commandeID);
		return null;
	}
	
	@Action(value = "insertCommande")
	public Commande insertCommande(String libelle, int idclient, String datecommande) {
		commandeService.insertCommande(commande);
		return null;
	}
	
	@Action(value = "updateCommande")
	public Commande updateCommande(String libelle, int idclient, String datecommande) {
		commandeService.updateCommande(commande);
		return null;
	}

	@Override
	public Commande getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
