package com.formation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.CommandeCreerDao;
import com.formation.persistence.CommandeCreer;

@Service
public class CommandeCreerServiceImp implements CommandeCreerService{

	
	@Autowired
	private CommandeCreerDao commandeCreerDao;
	
	@Transactional 
	@Override
	public void insertCommandeCreer(CommandeCreer commandeCreer) {
		 commandeCreerDao.insertCommandeCreer(commandeCreer);
		
	}

	@Transactional
	@Override
	public void updateCommandeCreer(CommandeCreer commandeCreer) {
		commandeCreerDao.updateCommandeCreer(commandeCreer);
		
	}

	@Transactional
	@Override
	public void removeCommandeCreer(long commandeCreerID) {
		commandeCreerDao.removeCommandeCreer(commandeCreerID);
		
	}

	@Transactional
	@Override
	public CommandeCreer getCommandeCreer(long commandeCreerID) {
		return commandeCreerDao.getCommandeCreer(commandeCreerID);
	}

	@Transactional
	@Override
	public List<CommandeCreer> getAllCommandeCreer() {
		return commandeCreerDao.getAllCommandeCreer();
	}

}
