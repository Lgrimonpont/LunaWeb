package com.formation.service;


import java.util.List;

import com.formation.persistence.CommandCreer;

public interface CommandCreerService {
	public void insertCommandCreer(CommandCreer commandCreer);
	public void updateCommandCreer(CommandCreer commandCreer);
	public void removeCommandCreer(int commandCreerID);
	public CommandCreer getCommandCreer(int commandCreerID);
	public List<CommandCreer> getAllCommandCreer();

}
