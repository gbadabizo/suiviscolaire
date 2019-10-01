package com.all4tic.suiviscolaire.dto;

public class EcoleDto {
	
	private int id_ecole ;
	private String nom ;
	private String adresse ;
	private  String ville ;
	private  String quartier;
	private String telephone ;
	private String email;
	private int status =1 ;
	
	public EcoleDto(int id_ecole, String nom, String adresse, String ville, String quartier, String telephone,
			String email, int status) {
		super();
		this.id_ecole = id_ecole;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.quartier = quartier;
		this.telephone = telephone;
		this.email = email;
		this.status = status;
	}
	
	public EcoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_ecole() {
		return id_ecole;
	}
	public void setId_ecole(int id_ecole) {
		this.id_ecole = id_ecole;
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
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
