package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/")
@Action(value = "index", results= {@Result(name = "success", type = "tiles", location = "login") })
public class IndexAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

}
