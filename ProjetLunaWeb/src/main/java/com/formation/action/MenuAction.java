package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/")
public class MenuAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Action(value = "accueilLink", results = { @Result(name = "accueil", type = "tiles", location = "accueil") })
	public String accueil() {
		return "accueil";
	}
	
	@Action(value = "clientLink", results = { @Result(name = "client", type = "tiles", location = "client") })
	public String client() {
		return "client";
	}
	@Action(value = "commandeLink", results = { @Result(name = "commande", type = "tiles", location = "commande") })
	public String commande() {
		return "commande";
	}
	@Action(value = "articleLink", results = { @Result(name = "article", type = "tiles", location = "article") })
	public String article() {
		return "article";
	}
	@Action(value = "userLink", results = { @Result(name = "user", type = "tiles", location = "user") })
	public String user() {
		return "user";
	}
	

}
