package com.formation.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.persistence.Article;
import com.formation.persistence.Client;
import com.formation.persistence.Commande;
import com.formation.persistence.CommandeCreer;
import com.formation.service.ArticleService;
import com.formation.service.ClientService;
import com.formation.service.CommandeCreerService;
import com.formation.service.CommandeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace(value = "/")
public class CommandeCreerAction extends ActionSupport implements ModelDriven<CommandeCreer> {

	@Autowired
	private CommandeCreerService commandeCreerService;

	@Autowired
	private CommandeService commandeService;

	@Autowired
	private ArticleService articleService;

	private static final long serialVersionUID = 1L;

	private CommandeCreer commandeCreer = new CommandeCreer();
	private List<CommandeCreer> listCommandeCreer = null;
	private long idCommandeCreer;
	private Boolean ajouter_modifier = false;
	private List<Long> listIdCommande = new ArrayList<Long>();
	private List<Long> listIdArticle = new ArrayList<Long>();

	@Override
	public CommandeCreer getModel() {
		return commandeCreer;
	}

	public void setListCommandeCreer() {
		listCommandeCreer = commandeCreerService.getAllCommandeCreer();
	}

	public List<CommandeCreer> getListCommandeCreer() {
		return listCommandeCreer;
	}

	@Action(value = "afficheCommandeCreer", results = {
			@Result(name = "commandeCreer", type = "tiles", location = "commandeCreer"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String afficheCommandeCreer() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			setListCommandeCreer();
			return "commandeCreer";
		}

	}

	@Action(value = "supprimerCommandeCreer", results = {
			@Result(name = "supprimer", type = "tiles", location = "commandeCreer"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String supprimer() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			System.out.println(idCommandeCreer);
			commandeCreerService.removeCommandeCreer(idCommandeCreer);
			setListCommandeCreer();
			return "supprimer";
		}

	}

	@Action(value = "modifierCommandeCreerLink", results = {
			@Result(name = "modifierLink", type = "tiles", location = "ajouterCommandeCreer"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String modifierCommandeCreerLink() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			ajouter_modifier = false;
			commandeCreer = commandeCreerService.getCommandeCreer(idCommandeCreer);
			setListCommandeCreer();
			setListIdCommande();
			setListIdArticle();
			return "modifierLink";
		}

	}

	@Action(value = "modifierCommandeCreer", results = {
			@Result(name = "modifier", type = "tiles", location = "commandeCreer"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String modifierCommandeCreer() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			commandeCreerService.updateCommandeCreer(commandeCreer);
			setListCommandeCreer();
			return "modifier";
		}

	}

	@Action(value = "ajouterCommandeCreerLink", results = {
			@Result(name = "ajouterLink", type = "tiles", location = "ajouterCommandeCreer"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String ajouterCommandeCreerLink() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			ajouter_modifier = true;
			setListCommandeCreer();
			setListIdCommande();
			setListIdArticle();
			return "ajouterLink";
		}

	}

	@Action(value = "ajouterCommandeCreer", results = {
			@Result(name = "ajouter", type = "tiles", location = "commandeCreer"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String ajouterCommandeCreer() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			commandeCreerService.insertCommandeCreer(commandeCreer);
			setListCommandeCreer();
			return "ajouter";
		}

	}

	@Action(value = "chercherCommandeCreerLink", results = {
			@Result(name = "chercherLink", type = "tiles", location = "chercherCommandeCreer"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String chercherCommandeCreerLink() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			return "chercherLink";
		}

	}

	@Action(value = "chercherCommandeCreer", results = {
			@Result(name = "chercher", type = "tiles", location = "chercherCommandeCreer"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String chercherCommandeCreer() {
		List<CommandeCreer> listCommandeCreerTemp = new ArrayList<CommandeCreer>();
		setListCommandeCreer();
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			for (int i = 0; i < listCommandeCreer.size(); i++) {
				if (listCommandeCreer.get(i).getIdcommande() == commandeCreer.getIdcommande()) {
					listCommandeCreerTemp.add(listCommandeCreer.get(i));
				}
			}
			listCommandeCreer = listCommandeCreerTemp;
			return "chercher";
		}

	}

	public long getIdCommandeCreer() {
		return idCommandeCreer;
	}

	public void setIdCommandeCreer(long idCommandeCreer) {
		this.idCommandeCreer = idCommandeCreer;
	}

	public Boolean getAjouter_modifier() {
		return ajouter_modifier;
	}

	public CommandeCreer getCommandeCreer() {
		return commandeCreer;
	}

	public void setCommandeCreer(CommandeCreer commandeCreer) {
		this.commandeCreer = commandeCreer;
	}

	public List<Long> getListIdCommande() {
		return listIdCommande;
	}

	public void setListIdCommande() {
		listIdCommande.clear();
		List<Commande> listCommande = commandeService.getAllCommande();
		for (int i = 0; i < listCommande.size(); i++) {
			this.listIdCommande.add(listCommande.get(i).getId());
		}
	}

	public List<Long> getListIdArticle() {
		return listIdArticle;
	}

	public void setListIdArticle() {
		listIdArticle.clear();
		List<Article> listArticle = articleService.getAllArticle();
		for (int i = 0; i < listArticle.size(); i++) {
			this.listIdArticle.add(listArticle.get(i).getId());
		}
	}
}
