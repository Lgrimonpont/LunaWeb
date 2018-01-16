package com.formation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.CommandCreerDao;
import com.formation.persistence.CommandCreer;

@Service
public class CommandCreerServiceImp implements CommandCreerService{

	
	@Autowired
	private CommandCreerDao commandCreerDao;
	
	@Transactional 
	@Override
	public void insertCommandCreer(CommandCreer commandCreer) {
		 commandCreerDao.insertCommandCreer(commandCreer);
		
	}

	@Transactional
	@Override
	public void updateCommandCreer(CommandCreer commandCreer) {
		commandCreerDao.updateCommandCreer(commandCreer);
		
	}

	@Transactional
	@Override
	public void removeCommandCreer(int commandCreerID) {
		commandCreerDao.removeCommandCreer(commandCreerID);
		
	}

	@Transactional
	@Override
	public CommandCreer getCommandCreer(int commandCreerID) {
		return commandCreerDao.getCommandCreer(commandCreerID);
	}

	@Transactional
	@Override
	public List<CommandCreer> getAllCommandCreer() {
		return commandCreerDao.getAllCommandCreer();
	}

}
