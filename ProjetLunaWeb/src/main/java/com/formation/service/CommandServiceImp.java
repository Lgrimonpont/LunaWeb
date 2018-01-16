package com.formation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.CommandDao;
import com.formation.persistence.Command;

@Service
public class CommandServiceImp implements CommandService {

	@Autowired
	private CommandDao commandDao;
	
	@Transactional
	@Override
	public void insertCommand(Command command) {
		commandDao.insertCommand(command);
		
	}

	@Transactional
	@Override
	public void updateCommand(Command command) {
		commandDao.updateCommand(command);
		
	}

	@Transactional
	@Override
	public void removeCommand(int commandId) {
		commandDao.removeCommand(commandId);
		
	}

	@Transactional
	@Override
	public Command getCommand(int commandId) {
		return commandDao.getCommand(commandId);
	}

	@Transactional
	@Override
	public List<Command> getAllCommand() {
		// TODO Auto-generated method stub
		return commandDao.getAllCommand();
	}

}
