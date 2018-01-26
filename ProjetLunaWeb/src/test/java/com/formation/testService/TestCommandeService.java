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
import com.formation.persistence.Client;
import com.formation.persistence.Commande;
import com.formation.service.CommandeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConteneurSpring.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCommandeService {

	@Autowired
	CommandeService commandeService;

	@Test
	public void testInsertCommande() {

		List<Commande> listCommande = commandeService.getAllCommande();
		int verifInsert = listCommande.size();

		Commande commande = new Commande();
		Client client = new Client();
		String libelle = "Informatique";
		int idClient = (int)client.getId();
		String dateCommande = "01/01/2000";

		commande.setLibelle(libelle);
		commande.setIdclient(idClient);
		commande.setDatecommande(dateCommande);

		commandeService.insertCommande(commande);
		assertEquals("insert effectué", verifInsert + 1, commandeService.getAllCommande().size());
		Commande commande2 = commandeService.getCommande(commande.getId());
		assertEquals("meme libelle", libelle, commande2.getLibelle());
		assertEquals("meme id client", idClient, commande2.getIdclient());
		assertEquals("meme date de commande", dateCommande, commande2.getDatecommande());

		commandeService.removeCommande(commande.getId());
	}

	@Test
	public void testUpdateArticle() {

		Commande commande = new Commande();
		Client client = new Client();
		String libelle = "Informatique";
		int idClient = (int)client.getId();
		String dateCommande = "01/01/2000";

		commande.setLibelle(libelle);
		commande.setIdclient(idClient);
		commande.setDatecommande(dateCommande);

		commandeService.insertCommande(commande);

		Client client2 = new Client();
		String libelle2 = "Electronique";
		int idClient2 = (int)client2.getId();
		String dateCommande2 = "01/01/2000";

		commande.setLibelle(libelle2);
		commande.setIdclient(idClient2);
		commande.setDatecommande(dateCommande2);

		commandeService.updateCommande(commande);
		Commande commande2 = commandeService.getCommande(commande.getId());
		assertEquals("meme libelle", libelle2, commande2.getLibelle());
		assertEquals("meme id client", idClient2, commande2.getIdclient());
		assertEquals("meme date de commande", dateCommande2, commande2.getDatecommande());
		
		commandeService.removeCommande(commande.getId());
	}

	@Test
	public void testRemoveArticle() {

		List<Commande> listCommande = commandeService.getAllCommande();
		int verifInsert = listCommande.size();

		Commande commande = new Commande();
		Client client = new Client();
		String libelle = "Informatique";
		int idClient = (int)client.getId();
		String dateCommande = "01/01/2000";

		commande.setLibelle(libelle);
		commande.setIdclient(idClient);
		commande.setDatecommande(dateCommande);
		
		commandeService.insertCommande(commande);

		commandeService.removeCommande(commande.getId());
		assertEquals("suppression effectué", verifInsert, commandeService.getAllCommande().size());
	}

}
