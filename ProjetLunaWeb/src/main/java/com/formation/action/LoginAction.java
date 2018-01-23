package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.persistence.User;
import com.formation.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@Action("login")
@Results(value = { @Result(name = "success", type="tiles",  location = "accueil"),
		@Result(name = "error", location = "/jsp/authentification.jsp") })
public class LoginAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	@Autowired
	private UserService userService;
	
	private static final long serialVersionUID = 1L;

	private User user1 = new User();  

	public String execute() {		
		
		if (userService.getUserConnection(user1.getLogin(), user1.getPass())) {
			return SUCCESS;
		} else {
			System.out.println("Le mot de passe ou le nom d'utilisateur est faux !");
			return ERROR;
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user1;
	}
}
