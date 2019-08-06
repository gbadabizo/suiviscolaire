package com.all4tic.suiviscolaire.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "eleve")
public class Eleve implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_eleve;
	@NotNull
	private String nom;
	@NotNull
	private String prenoms;
	private char sexe;
	private String adresse;
	private String telephone;
	private String matricule ;
	private int statut;
	
	@ManyToMany
	@JoinTable(name = "eleve_parent",
		joinColumns = { @JoinColumn(name = "id_eleve")},
		inverseJoinColumns = { @JoinColumn(name = "id_parent")})
	private Set<Parent> parents = new HashSet<>();
	
	@ManyToOne
    Classe classe;
	
	public Eleve(String nom, String prenoms, char sexe, String adresse, String telephone, int statut) {
		this.nom = nom;
		this.prenoms = prenoms;
		this.sexe = sexe;
		this.adresse = adresse;
		this.telephone = telephone;
		this.statut = statut;
	}

	public Long getId_eleve() {
		return id_eleve;
	}

	public void setId_eleve(Long id_eleve) {
		this.id_eleve = id_eleve;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
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
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public int getStatus() {
		return statut;
	}
	
	public void setStatus(int statut) {
		this.statut = statut;
	}
	
	public Set<Parent> getParents() {
		return parents;
	}
	
	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}
	
	public Classe getClasse() {
		return classe;
	}
	
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
	
	@Override
	public String toString() {
		return "Eleve{" +
			"id=" + id_eleve +
			", nom='" + nom + '\'' +
			", prenoms='" + prenoms + '\'' +
			", sexe=" + sexe +
			", adresse='" + adresse + '\'' +
			", telephone='" + telephone + '\'' +
			", status=" + statut +
			'}';
	}
}
