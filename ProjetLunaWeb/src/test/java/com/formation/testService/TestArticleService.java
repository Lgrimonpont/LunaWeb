package com.formation.testService;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.config.ConteneurSpring;
import com.formation.persistence.Article;
import com.formation.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConteneurSpring.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestArticleService {

	@Autowired
	ArticleService articleService;

	@Test
	public void testInsertArticle() {

		List<Article> listArticle = articleService.getAllArticle();
		int verifInsert = listArticle.size();

		Article article = new Article();
		int codeCategorie = 50;
		String categorie = "informatique";
		String designation = "ecran";
		int quantiteStock = 12;
		int prixUnitaire = 200;

		article.setCodeCategorie(codeCategorie);
		article.setCategorie(categorie);
		article.setDesignation(designation);
		article.setQuantitestock(quantiteStock);
		article.setPrixUnitaire(prixUnitaire);

		articleService.insertArticle(article);
		assertEquals("insert effectué", verifInsert + 1, articleService.getAllArticle().size());
		Article article2 = articleService.getArticle(article.getId());
		assertEquals("meme code categorie", codeCategorie, article2.getCodeCategorie());
		assertEquals("meme categorie", categorie, article2.getCategorie());
		assertEquals("meme designation", designation, article2.getDesignation());
		assertEquals("meme quantite stock", quantiteStock, article2.getQuantitestock());
		assertEquals("meme prix unitaire", prixUnitaire, article2.getPrixUnitaire());

		articleService.removeArticle(article.getId());
	}

	@Test
	public void testUpdateArticle() {

		Article article = new Article();
		int codeCategorie = 50;
		String categorie = "informatique";
		String designation = "ecran";
		int quantiteStock = 12;
		int prixUnitaire = 200;

		article.setCodeCategorie(codeCategorie);
		article.setCategorie(categorie);
		article.setDesignation(designation);
		article.setQuantitestock(quantiteStock);
		article.setPrixUnitaire(prixUnitaire);
		
		articleService.insertArticle(article);

		int codeCategorie2 = 30;
		String categorie2 = "electronique";
		String designation2 = "arduino";
		int quantiteStock2 = 5;
		int prixUnitaire2 = 50;

		article.setCodeCategorie(codeCategorie2);
		article.setCategorie(categorie2);
		article.setDesignation(designation2);
		article.setQuantitestock(quantiteStock2);
		article.setPrixUnitaire(prixUnitaire2);

		articleService.updateArticle(article);
		Article article2 = articleService.getArticle(article.getId());
		assertEquals("meme code categorie", codeCategorie2, article2.getCodeCategorie());
		assertEquals("meme categorie", categorie2, article2.getCategorie());
		assertEquals("meme designation", designation2, article2.getDesignation());
		assertEquals("meme quantite stock", quantiteStock2, article2.getQuantitestock());
		assertEquals("meme prix unitaire", prixUnitaire2, article2.getPrixUnitaire());

		articleService.removeArticle(article.getId());
	}

	@Test
	public void testRemoveArticle() {

		List<Article> listArticle = articleService.getAllArticle();
		int verifInsert = listArticle.size();

		Article article = new Article();
		int codeCategorie = 50;
		String categorie = "informatique";
		String designation = "ecran";
		int quantiteStock = 12;
		int prixUnitaire = 200;

		article.setCodeCategorie(codeCategorie);
		article.setCategorie(categorie);
		article.setDesignation(designation);
		article.setQuantitestock(quantiteStock);
		article.setPrixUnitaire(prixUnitaire);

		articleService.insertArticle(article);

		articleService.removeArticle(article.getId());
		assertEquals("suppression effectué", verifInsert, articleService.getAllArticle().size());
	}

}
