package com.all4tic.suiviscolaire.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Entity
@Table(name="ecole")
public class Ecole implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_ecole ;
	@Column(length=50)
	@NotNull @NotEmpty
	private String nom ;
	@Column(length=250)
	
	private String adresse ;
	@Column(length=50)
	@NotNull 
	private  String ville ;
	@Column(length=50)
	
	private  String quartier;
	@Column(length=15)
	@NotNull @NotEmpty
	private String telephone ;
	@Column(length=250)
	private String email;
	private int status =1 ;
	@OneToMany(
			mappedBy="ecole",
	        cascade = CascadeType.REMOVE
	    )
	
	List<EcoleEnseignant> ecoleEnseignants ;
	@ManyToMany(cascade = {
	        CascadeType.REMOVE
	    })
	    @JoinTable(name = "ecole_classe",
	        joinColumns = @JoinColumn(name = "id_ecole"),
	        inverseJoinColumns = @JoinColumn(name = "id_classe")
	    )
	private Set<Classe> classes = new HashSet<>();
	@OneToMany(
			mappedBy="ecole",
	        cascade = CascadeType.REMOVE
	    )
	List<EcoleEnseignantMatiereClasse> ecoleEnseignantMatiereClasses ;
	@OneToMany(
			mappedBy="ecole",
	        cascade = CascadeType.REMOVE
	    )
	List<Eleve> eleves ;
	public Ecole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ecole(String nom, String ville, String telephone) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.telephone = telephone;
	}

	public Ecole(int id_ecole, String nom, String adresse, String ville, String quartier, String telephone,
                 String email, int statut) {
		super();
		this.id_ecole = id_ecole;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.quartier = quartier;
		this.telephone = telephone;
		this.email = email;
		this.status = statut;

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

	public void setStatus(int statut) {
		this.status = statut;
	}

	public List<EcoleEnseignant> getEcoleEnseignants() {
		return ecoleEnseignants;
	}

	public void setEcoleEnseignants(List<EcoleEnseignant> ecoleEnseignants) {
		this.ecoleEnseignants = ecoleEnseignants;
	}

	public Set<Classe> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classe> classes) {
		this.classes = classes;
	}

	public List<EcoleEnseignantMatiereClasse> getEcoleEnseignantMatiereClasses() {
		return ecoleEnseignantMatiereClasses;
	}

	public void setEcoleEnseignantMatiereClasses(List<EcoleEnseignantMatiereClasse> ecoleEnseignantMatiereClasses) {
		this.ecoleEnseignantMatiereClasses = ecoleEnseignantMatiereClasses;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}
	
	

}
