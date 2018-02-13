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
import com.formation.persistence.Commande;
import com.formation.persistence.CommandeCreer;
import com.formation.service.CommandeCreerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConteneurSpring.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCommandeCreerService {

	@Autowired
	CommandeCreerService commandeCreerService;

	@Test
	public void testInsertCommandeCreer() {

		List<CommandeCreer> listCommandeCreer = commandeCreerService.getAllCommandeCreer();
		int verifInsert = listCommandeCreer.size();

		CommandeCreer commandeCreer = new CommandeCreer();
		Commande commande= new Commande();
		Article article=new Article();
		int idArticle = (int) article.getId();
		int quantite = 5;
		int idcommande = (int) commande.getId();
	

		commandeCreer.setIdArticle(idArticle);
		commandeCreer.setQuantite(quantite);
		commandeCreer.setIdcommande(idcommande);
	

		commandeCreerService.insertCommandeCreer(commandeCreer);
		assertEquals("insert effectué", verifInsert + 1, commandeCreerService.getAllCommandeCreer().size());
		CommandeCreer commandeCreer2 = commandeCreerService.getCommandeCreer(commandeCreer.getId());
		assertEquals("meme idArticle", idArticle, commandeCreer2.getIdArticle());
		assertEquals("meme quantite", quantite, commandeCreer2.getQuantite());
		assertEquals("meme idcommande", idcommande, commandeCreer2.getIdcommande());
	

		commandeCreerService.removeCommandeCreer(commandeCreer.getId());
	}

	@Test
	public void testUpdateCommandeCreer() {

		CommandeCreer commandeCreer = new CommandeCreer();
		Commande commande= new Commande();
		Article article=new Article();
		int idArticle = (int) article.getId();
		int quantite = 5;
		int idcommande = (int) commande.getId();

		commandeCreer.setIdArticle(idArticle);
		commandeCreer.setQuantite(quantite);
		commandeCreer.setIdcommande(idcommande);
		
		commandeCreerService.insertCommandeCreer(commandeCreer);

		Commande commande2= new Commande();
		Article article2=new Article();
		int idArticle2 = (int) article2.getId();
		int quantite2 = 9;
		int idcommande2 = (int) commande2.getId();

		commandeCreer.setIdArticle(idArticle2);
		commandeCreer.setQuantite(quantite2);
		commandeCreer.setIdcommande(idcommande2);

		commandeCreerService.updateCommandeCreer(commandeCreer);
		CommandeCreer commandeCreer2 = commandeCreerService.getCommandeCreer(commandeCreer.getId());
		assertEquals("meme idArticle", idArticle2, commandeCreer2.getIdArticle());
		assertEquals("meme quantite", quantite2, commandeCreer2.getQuantite());
		assertEquals("meme idcommande", idcommande2, commandeCreer2.getIdcommande());

		commandeCreerService.removeCommandeCreer(commandeCreer.getId());
	}

	@Test
	public void testRemoveCommandeCreer() {

		List<CommandeCreer> listCommandeCreer = commandeCreerService.getAllCommandeCreer();
		int verifInsert = listCommandeCreer.size();

		CommandeCreer commandeCreer = new CommandeCreer();
		Commande commande= new Commande();
		Article article=new Article();
		int idArticle = (int) article.getId();
		int quantite = 5;
		int idcommande = (int) commande.getId();

		commandeCreer.setIdArticle(idArticle);
		commandeCreer.setQuantite(quantite);
		commandeCreer.setIdcommande(idcommande);
		
		commandeCreerService.insertCommandeCreer(commandeCreer);

		commandeCreerService.removeCommandeCreer(commandeCreer.getId());
		assertEquals("suppression effectué", verifInsert, commandeCreerService.getAllCommandeCreer().size());
	}

}
