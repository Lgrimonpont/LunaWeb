package com.formation.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Command {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String libelle;
	
	@Column
	private int idclient;
	
	@Column
	private String datecommand;

	
	public Command(String libelle, int idclient, String datecommand) {
		this.libelle = libelle;
		this.idclient = idclient;
		this.datecommand = datecommand;
	}

	public Command() {
	
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getDatecommand() {
		return datecommand;
	}

	public void setDatecommand(String datecommand) {
		this.datecommand = datecommand;
	}

}
