package com.formation.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private int codeCategorie;
	
	@Column
	private String Categorie;
	
	@Column
	private String designation;
	
	@Column
	private int quantitestock;
	
	@Column
	private int prixUnitaire;

	public Article(int codeCategorie, String categorie, String designation, int quantitestock,
			int prixUnitaire) {
		this.codeCategorie = codeCategorie;
		this.Categorie = categorie;
		this.designation = designation;
		this.quantitestock = quantitestock;
		this.prixUnitaire = prixUnitaire;
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCodeCategorie() {
		return codeCategorie;
	}

	public void setCodeCategorie(int codeCategorie) {
		this.codeCategorie = codeCategorie;
	}

	public String getCategorie() {
		return Categorie;
	}

	public void setCategorie(String categorie) {
		Categorie = categorie;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getQuantitestock() {
		return quantitestock;
	}

	public void setQuantitestock(int quantitestock) {
		this.quantitestock = quantitestock;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

}
