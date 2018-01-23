package com.formation.dao;

import java.util.List;

import com.formation.persistence.CommandeCreer;

public interface CommandeCreerDao {
	public void insertCommandeCreer(CommandeCreer commandeCreer);

	public void updateCommandeCreer(CommandeCreer commandeCreer);

	public void removeCommandeCreer(int commandeCreerID);

	public CommandeCreer getCommandeCreer(int commandeCreerID);

	public List<CommandeCreer> getAllCommandeCreer();



}
