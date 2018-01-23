package com.formation.service;


import java.util.List;

import com.formation.persistence.Commande;


public interface CommandeService {
	public void insertCommande(Commande commande);
	public void updateCommande(Commande commande);
	public void removeCommande(int commandeId);
	public Commande getCommande(int commandeId);
	public List<Commande> getAllCommande();

}
