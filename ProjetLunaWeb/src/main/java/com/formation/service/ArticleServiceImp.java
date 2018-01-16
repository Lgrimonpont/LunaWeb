package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.ArticleDao;
import com.formation.persistence.Article;

public class ArticleServiceImp implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Transactional
	@Override
	public void insertArticle(Article article) {
		articleDao.insertArticle(article);
	}

	@Transactional
	@Override
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}

	@Transactional
	@Override
	public void removeArticle(int articleID) {
		articleDao.removeArticle(articleID);
	}

	@Transactional
	@Override
	public Article getArticle(int articleID) {
		return articleDao.getArticle(articleID);
	}

	@Transactional
	@Override
	public List<Article> getAllArticle() {
		return articleDao.getAllArticle();
	}
}
