package com.all4tic.suiviscolaire.dto;

import java.util.Date;


public class AnneeDto {
	private int id_annee ;
	private String libelle ;
	private Date date_debut ;
	private Date date_fin ;
	private int status ;
	public AnneeDto(int id_annee, String libelle, Date date_debut, Date date_fin, int status) {
		super();
		this.id_annee = id_annee;
		this.libelle = libelle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.status = status;
	}
	public AnneeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_annee() {
		return id_annee;
	}
	public void setId_annee(int id_annee) {
		this.id_annee = id_annee;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
