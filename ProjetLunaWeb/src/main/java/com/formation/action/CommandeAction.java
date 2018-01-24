package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
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
	private List<Commande> listCommande = null;
	private long idCommande;
	
	@Override
	public Commande getModel() {
		return commande;
	}
	
	public void setListCommande() {
		listCommande = commandeService.getAllCommande();
	}
	
	public List<Commande> getListCommande() {
		return listCommande;
	}
	
	@Action(value = "afficheCommande", results = { @Result(name = "commande", type="tiles", location="commande")} )
	public String afficheCommande() {
		setListCommande();
		return "commande";
	}
	@Action(value = "supprimerCommande", results = { @Result(name = "supprimer", type="tiles", location="commande")} )
	public String supprimer() {
		System.out.println(idCommande);
		commandeService.removeCommande(idCommande);
		setListCommande();
		return "supprimer";
	}
	
	
//	@Action(value = "insertCommande")
//	public Commande insertCommande(String libelle, int idclient, String datecommande) {
//		commandeService.insertCommande(commande);
//		return null;
//	}
//	
//	@Action(value = "updateCommande")
//	public Commande updateCommande(String libelle, int idclient, String datecommande) {
//		commandeService.updateCommande(commande);
//		return null;
//	}

	

}
