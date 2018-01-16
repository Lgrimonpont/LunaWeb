package com.formation.dao;

import java.util.List;

import com.formation.persistence.CommandCreer;

public interface CommandCreerDao {
	public void insertCommandCreer(CommandCreer commandCreer);

	public void updateCommandCreer(CommandCreer commandcreer);

	public void removeCommandCreer(int commandcreerID);

	public CommandCreer getCommandCreer(int commandcreerID);

	public List<CommandCreer> getAllCommandCreer();

}
