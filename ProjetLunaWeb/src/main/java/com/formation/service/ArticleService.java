package com.formation.service;

import java.util.List;

import com.formation.persistence.Article;

public interface ArticleService {
	public void insertArticle(Article article);

	public void updateArticle(Article article);

	public void removeArticle(int articleID);

	public Article getArticle(int articleID);

	public List<Article> getAllArticle();

}
