package com.formation.dao;

import java.util.List;

import com.formation.persistence.Commande;

public interface CommandeDao {
	public void insertCommande(Commande commande);

	public void updateCommande(Commande commande);

	public void removeCommande(long commandeId);

	public Commande getCommande(long commandeId);

	public List<Commande> getAllCommande();
}
