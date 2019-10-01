package com.all4tic.suiviscolaire.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public  class TypeSuivi implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_type;
	private String libelle;
	private String description;
	private int status;
	@OneToMany(mappedBy ="typeSuivi")
	private Set<SuiviGeneral> suivis;
	
	public TypeSuivi() {
	}
	
	public TypeSuivi(String libelle, String description, int status) {
		this.libelle = libelle;
		this.description = description;
		this.status = status;
	}

	

	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}

	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Set<SuiviGeneral> getSuivis() {
		return suivis;
	}

	public void setSuivis(Set<SuiviGeneral> suivis) {
		this.suivis = suivis;
	}

	@Override
	public String toString() {
		return "TypeSuivi{" +
			"id=" + id_type +
			", libelle='" + libelle + '\'' +
			", description='" + description + '\'' +
			", status=" + status +
			'}';
	}
}
