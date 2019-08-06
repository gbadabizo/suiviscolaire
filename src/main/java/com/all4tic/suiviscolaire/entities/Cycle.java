package com.all4tic.suiviscolaire.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cycle implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_cycle ;
	@Column(length=50)
	private String libelle;
	@Column(length=5)
	private String code ;
	private String description ;
	private int statut=1 ;
	public Cycle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cycle(int id_cycle, String libelle, String code, String description, int statut) {
		super();
		this.id_cycle = id_cycle;
		this.libelle = libelle;
		this.code = code;
		this.description = description;
		this.statut = statut;
	}
	public int getId_cycle() {
		return id_cycle;
	}
	public void setId_cycle(int id_cycle) {
		this.id_cycle = id_cycle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
	
}
