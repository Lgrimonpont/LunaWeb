package com.formation.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CommandeCreer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private long idcommande;
	
	@Column
	private long idArticle;
	
	@Column
	private int quantite;

	
	public CommandeCreer(long idcommande, long idArticle, int quantite) {
		this.idcommande = idcommande;
		this.idArticle = idArticle;
		this.quantite = quantite;
	}

	public CommandeCreer() {
		
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public long getIdcommande() {
		return idcommande;
	}

	public void setIdcommande(long idcommande) {
		this.idcommande = idcommande;
	}

	public long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}