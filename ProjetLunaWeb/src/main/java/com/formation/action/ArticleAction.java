package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.persistence.Article;
import com.formation.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ArticleAction extends ActionSupport implements ModelDriven<Article> {
	
	@Autowired
	private ArticleService articleService;
	
	private static final long serialVersionUID = 1L;

	private Article article = new Article();
	
	@Action(value = "removeArticle")
	public Article removeArticle(int commandID) {
		articleService.removeArticle(commandID);
		return null;
	}
	
	@Action(value = "insertArticle")
	public Article insertArticle(int codeCategorie, String categorie, String designation, int quantitestock, int prixUnitaire) {
		articleService.insertArticle(article);
		return null;
	}
	
	@Action(value = "updateArticle")
	public Article updateArticle(int codeCategorie, String categorie, String designation, int quantitestock, int prixUnitaire) {
		articleService.updateArticle(article);
		return null;
	}
	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
