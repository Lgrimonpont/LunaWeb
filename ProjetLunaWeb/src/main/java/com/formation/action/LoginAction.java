package com.formation.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.persistence.User;
import com.formation.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@Action(value = "login", results = { @Result(name = "success", type = "tiles", location = "accueil"),
		@Result(name = "error", type = "tiles", location = "login") })
public class LoginAction extends ActionSupport implements ModelDriven<User>, SessionAware {

	/**
	 * 
	 */
	@Autowired
	private UserService userService;

	private SessionMap<String, Object> sessionMap;

	private Boolean error = false;

	private static final long serialVersionUID = 1L;

	private User user1 = new User();

	public String execute() {

		if (userService.getUserConnection(user1.getLogin(), user1.getPass())) {
			error = false;
			sessionMap.put("login", "true");
			sessionMap.put("name", user1.getLogin());
			return SUCCESS;
		} else {
			error = true;
			System.out.println("Le mot de passe ou le nom d'utilisateur est faux !");
			return ERROR;
		}
	}

	@Action(value = "logout", results = { @Result(name = "logout", type = "tiles", location = "login") })
	public String logout() {
		if (sessionMap != null) {
			sessionMap.invalidate();
		}
		return "logout";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user1;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}
}
