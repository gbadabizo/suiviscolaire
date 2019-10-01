package com.all4tic.suiviscolaire.dto;

import java.util.Date;


public class EleveDto {
	private Long id_eleve;
	private String nom;
	private String prenoms;
	private char sexe;
	private String telephone;
	private String matricule ;
	private Date datenaiss ;
	private int statut;
	public EleveDto(Long id_eleve, String nom, String prenoms, char sexe, String telephone, String matricule,
			Date datenaiss, int statut) {
		super();
		this.id_eleve = id_eleve;
		this.nom = nom;
		this.prenoms = prenoms;
		this.sexe = sexe;
		this.telephone = telephone;
		this.matricule = matricule;
		this.datenaiss = datenaiss;
		this.statut = statut;
	}
	public EleveDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId_eleve() {
		return id_eleve;
	}
	public void setId_eleve(Long id_eleve) {
		this.id_eleve = id_eleve;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Date getDatenaiss() {
		return datenaiss;
	}
	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
}
