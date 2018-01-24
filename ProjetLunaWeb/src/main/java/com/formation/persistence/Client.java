package com.formation.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String dateCreation;

	@Column
	private String carteFidelite;

	@Column
	private String prenom;

	@Column
	private String nom;

	@Column
	private String adresse;

	@Column
	private int codePostal;

	@Column
	private String fixe;

	@Column
	private String mobile;

	@Column
	private String email;

	@Column
	private String remarques;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String dateCreation, String carteFidelite, String prenom, String nom, String adresse, int codePostal,
			String fixe, String mobile, String email, String remarques) {
		this.dateCreation = dateCreation;
		this.carteFidelite = carteFidelite;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.fixe = fixe;
		this.mobile = mobile;
		this.email = email;
		this.remarques = remarques;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getCarteFidelite() {
		return carteFidelite;
	}

	public void setCarteFidelite(String carteFidelite) {
		this.carteFidelite = carteFidelite;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getFixe() {
		return fixe;
	}

	public void setFixe(String fixe) {
		this.fixe = fixe;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
