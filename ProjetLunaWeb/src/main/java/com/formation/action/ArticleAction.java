package com.formation.action;

import java.util.ArrayList;
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
	private Boolean ajouter_modifier=false;
	
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
	
	@Action(value = "modifierArticleLink", results = { @Result(name = "modifierLink", type = "tiles", location = "ajouterArticle") })
	public String modifierArticleLink() {
		ajouter_modifier=false;
		article=articleService.getArticle(idArticle);
		setListArticle();
		return "modifierLink";
	}

	@Action(value = "modifierArticle", results = { @Result(name = "modifier", type = "tiles", location = "article") })
	public String modifierArticle() {
		articleService.updateArticle(article);		
		setListArticle();
		return "modifier";
	}
	
	@Action(value = "ajouterArticleLink", results = { @Result(name = "ajouterLink", type = "tiles", location = "ajouterArticle") })
	public String ajouterArticleLink() {
		ajouter_modifier=true;
		setListArticle();
		return "ajouterLink";
	}
	
	@Action(value = "ajouterArticle", results = { @Result(name = "ajouter", type = "tiles", location = "article") })
	public String ajouterArticle() {
		articleService.insertArticle(article);
		setListArticle();
		return "ajouter";
	}
	
	@Action(value = "chercherArticleLink", results = { @Result(name = "chercherLink", type = "tiles", location = "chercherArticle") })
	public String chercherArticleLink() {
		return "chercherLink";
	}
	
	@Action(value = "chercherArticle", results = { @Result(name = "chercher", type = "tiles", location = "chercherArticle") })
	public String chercherArticle() {
		List<Article> listArticleTemp=new ArrayList<Article>();
		setListArticle();
		for (int i = 0; i < listArticle.size(); i++) {
			if(listArticle.get(i).getDesignation()==article.getDesignation())
			{
				listArticleTemp.add(listArticle.get(i));				
			}
		}
		listArticle=listArticleTemp;
		return "chercher";
	}

	public long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

	public Boolean getAjouter_modifier() {
		return ajouter_modifier;
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
