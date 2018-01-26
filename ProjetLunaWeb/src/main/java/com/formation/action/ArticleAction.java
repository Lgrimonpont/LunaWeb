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
	private Boolean ajouter_modifier = false;

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

	@Action(value = "afficheArticle", results = { @Result(name = "article", type = "tiles", location = "article"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String afficheArticle() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			setListArticle();
			return "article";
		}

	}

	@Action(value = "supprimerArticle", results = { @Result(name = "supprimer", type = "tiles", location = "article"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String supprimer() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			System.out.println(idArticle);
			articleService.removeArticle(idArticle);
			setListArticle();
			return "supprimer";
		}

	}

	@Action(value = "modifierArticleLink", results = {
			@Result(name = "modifierLink", type = "tiles", location = "ajouterArticle"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String modifierArticleLink() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			ajouter_modifier = false;
			article = articleService.getArticle(idArticle);
			setListArticle();
			return "modifierLink";
		}

	}

	@Action(value = "modifierArticle", results = { @Result(name = "modifier", type = "tiles", location = "article"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String modifierArticle() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			articleService.updateArticle(article);
			setListArticle();
			return "modifier";
		}

	}

	@Action(value = "ajouterArticleLink", results = {
			@Result(name = "ajouterLink", type = "tiles", location = "ajouterArticle"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String ajouterArticleLink() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			ajouter_modifier = true;
			setListArticle();
			return "ajouterLink";
		}

	}

	@Action(value = "ajouterArticle", results = { @Result(name = "ajouter", type = "tiles", location = "article"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String ajouterArticle() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			articleService.insertArticle(article);
			setListArticle();
			return "ajouter";
		}

	}

	@Action(value = "chercherArticleLink", results = {
			@Result(name = "chercherLink", type = "tiles", location = "chercherArticle"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String chercherArticleLink() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			return "chercherLink";
		}

	}

	@Action(value = "chercherArticle", results = {
			@Result(name = "chercher", type = "tiles", location = "chercherArticle"),
			@Result(name = "login", type = "tiles", location = "login") })
	public String chercherArticle() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			List<Article> listArticleTemp = new ArrayList<Article>();
			setListArticle();
			for (int i = 0; i < listArticle.size(); i++) {
				if (listArticle.get(i).getDesignation().equals(article.getDesignation())) {
					listArticleTemp.add(listArticle.get(i));
				}
			}
			listArticle = listArticleTemp;
			return "chercher";
		}

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
