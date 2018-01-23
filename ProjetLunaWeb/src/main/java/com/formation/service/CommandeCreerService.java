package com.formation.service;


import java.util.List;

import com.formation.persistence.CommandeCreer;

public interface CommandeCreerService {
	public void insertCommandeCreer(CommandeCreer commandeCreer);
	public void updateCommandeCreer(CommandeCreer commandeCreer);
	public void removeCommandeCreer(int commandeCreerID);
	public CommandeCreer getCommandeCreer(int commandeCreerID);
	public List<CommandeCreer> getAllCommandeCreer();

}
