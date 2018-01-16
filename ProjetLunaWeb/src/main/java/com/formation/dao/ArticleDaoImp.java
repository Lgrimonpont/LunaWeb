package com.formation.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.persistence.Article;

@Repository
public class ArticleDaoImp implements ArticleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Article> getAllArticle() {
		@SuppressWarnings("unchecked")
		TypedQuery<Article> query = (TypedQuery<Article>) (sessionFactory.getCurrentSession()).createQuery("from Article");
		return query.getResultList();
	}

	@Override
	public Article getArticle(int articleID) {
		@SuppressWarnings("unchecked")
		TypedQuery<Article> query = (TypedQuery<Article>) (sessionFactory.getCurrentSession()).createQuery("from Article where id="+articleID);
		return query.getResultList().get(0);
	}

	@Override
	public void insertArticle(Article article) {
		sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public void removeArticle(int articleID) {
		@SuppressWarnings("unchecked")
		TypedQuery<Article> query = (TypedQuery<Article>) (sessionFactory.getCurrentSession()).createQuery("delete from Article where id="+articleID);
        query.executeUpdate();
	}

	@Override
	public void updateArticle(Article article) {
		@SuppressWarnings("unchecked")
		TypedQuery<Article> query = (TypedQuery<Article>) (sessionFactory.getCurrentSession())
				.createQuery("UPDATE Article SET Categorie='"+article.getCategorie()+"',codeCategorie='"+article.getCodeCategorie()+"',designation='"+article.getDesignation()+"', prixUnitaire='"+article.getPrixUnitaire()+"',quantitestock='"+article.getQuantitestock()+"' WHERE id='"+article.getId()+"'");
		query.executeUpdate();
	}

}
