package com.formation.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.persistence.Client;
import com.formation.persistence.Commande;
import com.formation.service.ClientService;
import com.formation.service.CommandeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace(value = "/")
public class CommandeAction extends ActionSupport implements ModelDriven<Commande> {

	@Autowired
	private CommandeService commandeService;

	@Autowired
	private ClientService clientService;

	private static final long serialVersionUID = 1L;

	private Commande commande = new Commande();
	private List<Commande> listCommande = null;
	private long idCommande;
	private Boolean ajouter_modifier = false;
	private List<Long> listIdClient = new ArrayList<Long>();

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

	@Action(value = "afficheCommande", results = { @Result(name = "commande", type = "tiles", location = "commande"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String afficheCommande() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			setListCommande();
			return "commande";
		}

	}

	@Action(value = "supprimerCommande", results = { @Result(name = "supprimer", type = "tiles", location = "commande"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String supprimer() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			System.out.println(idCommande);
			commandeService.removeCommande(idCommande);
			setListCommande();
			return "supprimer";
		}

	}

	@Action(value = "modifierCommandeLink", results = {
			@Result(name = "modifierLink", type = "tiles", location = "ajouterCommande"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String modifierCommandeLink() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			ajouter_modifier = false;
			commande = commandeService.getCommande(idCommande);
			setListCommande();
			return "modifierLink";
		}

	}

	@Action(value = "modifierCommande", results = { @Result(name = "modifier", type = "tiles", location = "commande"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String modifierCommande() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			commandeService.updateCommande(commande);
			setListCommande();
			return "modifier";
		}

	}

	@Action(value = "ajouterCommandeLink", results = {
			@Result(name = "ajouterLink", type = "tiles", location = "ajouterCommande"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String ajouterCommandeLink() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			ajouter_modifier = true;
			setListCommande();
			setListIdClient();
			return "ajouterLink";
		}

	}

	@Action(value = "ajouterCommande", results = { @Result(name = "ajouter", type = "tiles", location = "commande"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String ajouterCommande() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			commandeService.insertCommande(commande);
			setListCommande();
			return "ajouter";
		}

	}

	@Action(value = "chercherCommandeLink", results = {
			@Result(name = "chercherLink", type = "tiles", location = "chercherCommande"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String chercherCommandeLink() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			return "chercherLink";
		}

	}

	@Action(value = "chercherCommande", results = {
			@Result(name = "chercher", type = "tiles", location = "chercherCommande"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String chercherCommande() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			List<Commande> listCommandeTemp = new ArrayList<Commande>();
			setListCommande();
			for (int i = 0; i < listCommande.size(); i++) {
				if (listCommande.get(i).getId() == commande.getId()) {
					listCommandeTemp.add(listCommande.get(i));
				}
			}
			listCommande = listCommandeTemp;
			return "chercher";
		}

	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public Boolean getAjouter_modifier() {
		return ajouter_modifier;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<Long> getListIdClient() {
		return listIdClient;
	}

	public void setListIdClient() {
		listIdClient.clear();
		List<Client> listClient = clientService.getAllClient();
		for (int i = 0; i < listClient.size(); i++) {
			this.listIdClient.add(listClient.get(i).getId());
		}
	}
}
