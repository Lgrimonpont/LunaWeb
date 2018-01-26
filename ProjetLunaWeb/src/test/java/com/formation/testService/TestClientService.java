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
import com.formation.persistence.Client;
import com.formation.service.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConteneurSpring.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClientService {

	@Autowired
	ClientService clientService;
	
	

	@Test
	public void testInsertClient() {

		List<Client> listClient = clientService.getAllClient();
		int verifInsert = listClient.size();

		Client client = new Client();
		String adresse = "1 rue des rues";
		String carteFidelite = "oui";
		int codePostal = 59000;
		String dateCreation = "01/01/2000";
		String email = "email@gmail.com";
		String fixe = "0302010605";
		String mobile = "0602010605";
		String nom = "Paul";
		String prenom = "Logan";
		String remarques = "remarques";

		client.setAdresse(adresse);
		client.setCarteFidelite(carteFidelite);
		client.setCodePostal(codePostal);
		client.setDateCreation(dateCreation);
		client.setEmail(email);
		client.setFixe(fixe);
		client.setMobile(mobile);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setRemarques(remarques);

		clientService.insertClient(client);
		assertEquals("insert effectué", verifInsert+1, clientService.getAllClient().size());
		Client client2 = clientService.getClient(client.getId());
		assertEquals("meme adresse", adresse, client2.getAdresse());
		assertEquals("meme carte de fidelite", carteFidelite, client2.getCarteFidelite());
		assertEquals("meme code postal", codePostal, client2.getCodePostal());
		assertEquals("meme date de creation", dateCreation, client2.getDateCreation());
		assertEquals("meme email", email, client2.getEmail());
		assertEquals("meme fixe", fixe, client2.getFixe());
		assertEquals("meme mobile", mobile, client2.getMobile());
		assertEquals("meme nom", nom, client2.getNom());
		assertEquals("meme prenom", prenom, client2.getPrenom());
		assertEquals("meme remarques", remarques, client2.getRemarques());
		
		clientService.removeClient(client.getId());
	}
	
	@Test
	public void testUpdateClient() {

		Client client = new Client();
		String adresse = "1 rue des rues";
		String carteFidelite = "oui";
		int codePostal = 59000;
		String dateCreation = "01/01/2000";
		String email = "email@gmail.com";
		String fixe = "0302010605";
		String mobile = "0602010605";
		String nom = "Paul";
		String prenom = "Logan";
		String remarques = "remarques";

		client.setAdresse(adresse);
		client.setCarteFidelite(carteFidelite);
		client.setCodePostal(codePostal);
		client.setDateCreation(dateCreation);
		client.setEmail(email);
		client.setFixe(fixe);
		client.setMobile(mobile);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setRemarques(remarques);

		clientService.insertClient(client);

		String adresse2 = "3 rue des rues";
		String carteFidelite2 = "non";
		int codePostal2 = 59370;
		String dateCreation2 = "02/02/2002";
		String email2 = "email2@gmail.com";
		String fixe2 = "0303010605";
		String mobile2 = "0603010605";
		String nom2 = "Logan";
		String prenom2 = "Paul";
		String remarques2 = "aucune remarques";

		client.setAdresse(adresse2);
		client.setCarteFidelite(carteFidelite2);
		client.setCodePostal(codePostal2);
		client.setDateCreation(dateCreation2);
		client.setEmail(email2);
		client.setFixe(fixe2);
		client.setMobile(mobile2);
		client.setNom(nom2);
		client.setPrenom(prenom2);
		client.setRemarques(remarques2);

		clientService.updateClient(client);
		Client client2 = clientService.getClient(client.getId());
		assertEquals("meme adresse", adresse2, client2.getAdresse());
		assertEquals("meme carte de fidelite", carteFidelite2, client2.getCarteFidelite());
		assertEquals("meme code postal", codePostal2, client2.getCodePostal());
		assertEquals("meme date de creation", dateCreation2, client2.getDateCreation());
		assertEquals("meme email", email2, client2.getEmail());
		assertEquals("meme fixe", fixe2, client2.getFixe());
		assertEquals("meme mobile", mobile2, client2.getMobile());
		assertEquals("meme nom", nom2, client2.getNom());
		assertEquals("meme prenom", prenom2, client2.getPrenom());
		assertEquals("meme remarques", remarques2, client2.getRemarques());
		
		clientService.removeClient(client.getId());
	}
	
	@Test
	public void testRemoveClient() {		
		
		List<Client> listClient = clientService.getAllClient();
		int verifInsert = listClient.size();

		Client client = new Client();
		String adresse = "1 rue des rues";
		String carteFidelite = "oui";
		int codePostal = 59000;
		String dateCreation = "01/01/2000";
		String email = "email@gmail.com";
		String fixe = "0302010605";
		String mobile = "0602010605";
		String nom = "Paul";
		String prenom = "Logan";
		String remarques = "remarques";

		client.setAdresse(adresse);
		client.setCarteFidelite(carteFidelite);
		client.setCodePostal(codePostal);
		client.setDateCreation(dateCreation);
		client.setEmail(email);
		client.setFixe(fixe);
		client.setMobile(mobile);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setRemarques(remarques);

		clientService.insertClient(client);

		clientService.removeClient(client.getId());
		assertEquals("suppression effectué", verifInsert, clientService.getAllClient().size());
	}

}
