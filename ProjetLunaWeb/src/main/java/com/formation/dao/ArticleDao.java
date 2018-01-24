package com.formation.dao;
import java.util.List;

import com.formation.persistence.Article;

public interface ArticleDao {
	public void insertArticle(Article article);

	public void updateArticle(Article article);

	public void removeArticle(long articleID);

	public Article getArticle(long articleID);

	public List<Article> getAllArticle();
}
