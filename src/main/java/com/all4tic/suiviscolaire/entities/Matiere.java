package com.all4tic.suiviscolaire.entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="matiere")
public class Matiere implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id_matiere ;
	@Column(length=50)
	@NotEmpty
	private String libelle ;
	@Column(length = 10)
	private String code ;
	@Column(length=250)
	private String description;
	private int status=1;
	@ManyToMany(cascade = {
	        CascadeType.REMOVE
	    })
	    @JoinTable(name = "enseignant_matiere",
	        joinColumns = @JoinColumn(name = "id_matiere"),
	        inverseJoinColumns = @JoinColumn(name = "id_enseignant")
	    )
	
	private Set<Enseignant> enseignants = new HashSet<>();
	@ManyToMany(cascade = {
	        CascadeType.REMOVE
	    })
	    @JoinTable(name = "classe_matiere",
	        joinColumns = @JoinColumn(name = "id_matiere"),
	        inverseJoinColumns = @JoinColumn(name = "id_classe")
	    )
	private Set<Classe> classes = new HashSet<>();
	@OneToMany(
			mappedBy="matiere",
	        cascade = CascadeType.REMOVE
	    )
	List<EcoleEnseignantMatiereClasse> ecoleEnseignantMatiereClasses ;
	@OneToMany(mappedBy ="enseignant")
	private Set<SuiviEleve> suiviEleves ;
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Matiere(int id_matiere, String libelle, String description, int statut) {
		super();
		this.id_matiere = id_matiere;
		this.libelle = libelle;
		this.description = description;
		this.status = statut;
	}

	public Matiere(String libelle, String code, String description, int status) {
		this.libelle = libelle;
		this.code = code;
		this.description = description;
		this.status = status;
	}

	public Matiere(String libelle, String description) {
		super();
		this.libelle = libelle;
		this.description = description;
	}
	public int getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
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
	public void setStatus(int statut) {
		this.status = statut;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
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
	public Set<SuiviEleve> getSuiviEleves() {
		return suiviEleves;
	}
	public void setSuiviEleves(Set<SuiviEleve> suiviEleves) {
		this.suiviEleves = suiviEleves;
	}
	
	
}
