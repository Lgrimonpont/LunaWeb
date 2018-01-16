package com.formation.service;


import java.util.List;

import com.formation.persistence.Command;


public interface CommandService {
	public void insertCommand(Command command);
	public void updateCommand(Command command);
	public void removeCommand(int commandId);
	public Command getCommand(int commandId);
	public List<Command> getAllCommand();

}
