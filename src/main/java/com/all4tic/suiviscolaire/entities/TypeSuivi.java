package com.all4tic.suiviscolaire.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public  class TypeSuivi implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_type;
	private String libelle;
	private String description;
	private int status;
	
	public TypeSuivi() {
	}
	
	public TypeSuivi(String libelle, String description, int status) {
		this.libelle = libelle;
		this.description = description;
		this.status = status;
	}

	public Long getId_type() {
		return id_type;
	}

	public void setId_type(Long id_type) {
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
