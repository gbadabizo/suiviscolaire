package com.all4tic.suiviscolaire.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.all4tic.suiviscolaire.entities.Matiere;

public class EnseignantDto implements Serializable {
	private int id_enseignant ;
	private String nom ;
	private String prenoms ;
	private String telephone ;
	private String email ;
	private int status;
	private Set<MatiereDto> matieres =new HashSet<>();
	public EnseignantDto(int id_enseignant, String nom, String prenoms, String telephone, String email, int status,
			Set<MatiereDto> matieres) {
		super();
		this.id_enseignant = id_enseignant;
		this.nom = nom;
		this.prenoms = prenoms;
		this.telephone = telephone;
		this.email = email;
		this.status = status;
		this.matieres = matieres;
	}
	public EnseignantDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_enseignant() {
		return id_enseignant;
	}
	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
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
	public Set<MatiereDto> getMatieres() {
		return matieres;
	}
	public void setMatieres(Set<MatiereDto> matieres) {
		this.matieres = matieres;
	}
		
	
}
