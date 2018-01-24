package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.persistence.Article;
import com.formation.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace(value = "/")
public class ArticleAction extends ActionSupport implements ModelDriven<Article> {
	
	@Autowired
	private ArticleService articleService;
	
	private static final long serialVersionUID = 1L;
	
	private Article article = new Article();
	private List<Article> listArticle = null;
	private long idArticle;
	
	@Override
	public Article getModel() {
		return article;
	}
	
	public void setListArticle() {
		listArticle = articleService.getAllArticle();
	}
	
	public List<Article> getListArticle() {
		return listArticle;
	}
	
	
	@Action(value = "afficheArticle", results = { @Result(name = "article", type="tiles", location="article")} )
	public String afficheArticle() {
		setListArticle();
		return "article";
	}
	
	@Action (value = "supprimerArticle", results = { @Result(name = "supprimer", type="tiles", location = "article" )})
	public String supprimer() {
		System.out.println(idArticle);
		articleService.removeArticle(idArticle);
		setListArticle();
		return "supprimer";
	}
	

	
	
//	@Action(value = "insertArticle")
//	public Article insertArticle(int codeCategorie, String categorie, String designation, int quantitestock, int prixUnitaire) {
//		articleService.insertArticle(article);
//		return null;
//	}
//	
//	@Action(value = "updateArticle")
//	public Article updateArticle(int codeCategorie, String categorie, String designation, int quantitestock, int prixUnitaire) {
//		articleService.updateArticle(article);
//		return null;
//	}
	public long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

}
