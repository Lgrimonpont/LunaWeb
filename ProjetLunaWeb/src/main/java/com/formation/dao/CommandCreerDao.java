package com.formation.dao;

import java.util.List;

import com.formation.persistence.CommandCreer;

public interface CommandCreerDao {
	public void insertCommandCreer(CommandCreer commandCreer);

	public void updateCommandCreer(CommandCreer commandCreer);

	public void removeCommandCreer(int commandCreerID);

	public CommandCreer getCommandCreer(int commandCreerID);

	public List<CommandCreer> getAllCommandCreer();

}
