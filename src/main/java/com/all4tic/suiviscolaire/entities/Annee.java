package com.all4tic.suiviscolaire.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="annee")
public class Annee implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id_annee ;
	@Column(length=12)
	private String libelle ;
	@Temporal(TemporalType.DATE) //TemporalType.DATE: maps the date as java.sql.Date.
	private Date date_debut ;
	@Temporal(TemporalType.DATE)
	private Date date_fin ;

	private int status =1 ;
	public Annee() {
		super();
		
	}
	public Annee(int id_annee, String libelle, Date date_debut, Date date_fin, int statut) {
		super();
		this.id_annee = id_annee;
		this.libelle = libelle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.status = statut;
	}
	public Annee(String libelle, Date date_debut) {
		super();
		this.libelle = libelle;
		this.date_debut = date_debut;
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
	public void setStatus(int statut) {
		this.status = statut;
	}

	
	
	
}
