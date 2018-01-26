package com.formation.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
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

	@Action(value = "accueilLink", results = { @Result(name = "accueil", type = "tiles", location = "accueil"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String accueil() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			return "accueil";
		}

	}

	@Action(value = "clientLink", results = { @Result(name = "client", type = "tiles", location = "client"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String client() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			return "client";
		}

	}

	@Action(value = "commandeLink", results = { @Result(name = "commande", type = "tiles", location = "commande"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String commande() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			return "commande";
		}

	}

	@Action(value = "articleLink", results = { @Result(name = "article", type = "tiles", location = "article"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String article() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			return "article";
		}

	}

	@Action(value = "userLink", results = { @Result(name = "user", type = "tiles", location = "user"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String user() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			return "user";
		}

	}

}
