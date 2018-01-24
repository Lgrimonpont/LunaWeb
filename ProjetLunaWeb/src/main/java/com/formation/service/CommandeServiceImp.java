package com.formation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.CommandeDao;
import com.formation.persistence.Commande;

@Service
public class CommandeServiceImp implements CommandeService {

	@Autowired
	private CommandeDao commandeDao;
	
	@Transactional
	@Override
	public void insertCommande(Commande commande) {
		commandeDao.insertCommande(commande);
		
	}

	@Transactional
	@Override
	public void updateCommande(Commande commande) {
		commandeDao.updateCommande(commande);
		
	}

	@Transactional
	@Override
	public void removeCommande(long commandeId) {
		commandeDao.removeCommande(commandeId);
		
	}

	@Transactional
	@Override
	public Commande getCommande(long commandeId) {
		return commandeDao.getCommande(commandeId);
	}

	@Transactional
	@Override
	public List<Commande> getAllCommande() {
		// TODO Auto-generated method stub
		return commandeDao.getAllCommande();
	}

}
