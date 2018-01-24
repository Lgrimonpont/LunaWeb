package com.formation.dao;

import java.util.List;

import com.formation.persistence.CommandeCreer;

public interface CommandeCreerDao {
	public void insertCommandeCreer(CommandeCreer commandeCreer);

	public void updateCommandeCreer(CommandeCreer commandeCreer);

	public void removeCommandeCreer(long commandeCreerID);

	public CommandeCreer getCommandeCreer(long commandeCreerID);

	public List<CommandeCreer> getAllCommandeCreer();



}
