package com.all4tic.suiviscolaire.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parent")
public class Parent implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_parent;

	private String nom;

	private String prenoms;

	private String telephone;

	private String telephone2;

	private String email;
	
	
	private int statut;
	
	@ManyToMany(mappedBy = "parents")
	@JsonIgnore
	private Set<Eleve> eleves = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PARENT_SUIVI",
		joinColumns = { @JoinColumn(name = "PARENTS_ID")},
		inverseJoinColumns = { @JoinColumn(name = "SUIVIS_ID")})
	private Set<Suivi> suivis = new HashSet<>();
	
	public Parent(String nom, String prenoms, String telephone, String telephone2, String email, int statut) {
		this.nom = nom;
		this.prenoms = prenoms;
		this.telephone = telephone;
		this.telephone2 = telephone2;
		this.email = email;
		this.statut = statut;
	}

	public Long getId_parent() {
		return id_parent;
	}

	public void setId_parent(Long id_parent) {
		this.id_parent = id_parent;
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
	
	public String getTelephone2() {
		return telephone2;
	}
	
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getStatut() {
		return statut;
	}
	
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
	public Set<Eleve> getEleves() {
		return eleves;
	}
	
	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}
	
	public Set<Suivi> getSuivis() {
		return suivis;
	}
	
	public void setSuivis(Set<Suivi> suivis) {
		this.suivis = suivis;
	}

	
	@Override
	public String toString() {
		return "Parent{" +
			"id=" + id_parent +
			", nom='" + nom + '\'' +
			", prenoms='" + prenoms + '\'' +
			", telephone='" + telephone + '\'' +
			", telephone2='" + telephone2 + '\'' +
			", email='" + email + '\'' +
			", statut=" + statut +
			'}';
	}
}
