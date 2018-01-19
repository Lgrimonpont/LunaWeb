package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/")
public class TemplateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value = "welcomeLink", results = { @Result(name = "welcome", type = "tiles", location = "welcome") })
	public String welcome() {
		return "welcome";
	}
	@Action(value = "friendsLink", results = { @Result(name = "friends", type = "tiles", location = "friends") })
	public String friends() {
		return "friends";
	}
	@Action(value = "officeLink", results = { @Result(name = "office", type = "tiles", location = "office") })
	public String office() {
		return "office";
	}
}
