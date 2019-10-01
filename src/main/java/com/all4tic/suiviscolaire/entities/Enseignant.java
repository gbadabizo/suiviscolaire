package com.all4tic.suiviscolaire.entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name="enseignant")
@Entity
public class Enseignant implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id_enseignant ;
	@Column(length=50)
	@NotEmpty
	private String nom ;
	@Column(length=150)
	@NotEmpty
	private String prenoms ;
	@Column(length=15)
	@NotEmpty
	private String telephone ;
	@Column(length=250)
	private String email ;
	private int type ;
	private int status =1;
	@JsonIgnore
	@OneToMany(
			mappedBy="enseignant",
	        cascade = CascadeType.REMOVE
	    )

	private List<EcoleEnseignant> ecoleEnseignants ;
	@JsonIgnore
	@ManyToMany(cascade = {
	        CascadeType.REMOVE
	    })
	    @JoinTable(name = "enseignant_matiere",
	        joinColumns = @JoinColumn(name = "id_enseignant"),
	        inverseJoinColumns = @JoinColumn(name = "id_matiere")
	    )
	private Set<Matiere> matieres = new HashSet<>();
	@JsonIgnore
	@OneToMany( 
			mappedBy="enseignant",
	        cascade = CascadeType.REMOVE
	    )
	List<EcoleEnseignantMatiereClasse> ecoleEnseignantMatiereClasses ;
	@OneToMany(mappedBy ="enseignant")
	private Set<SuiviGeneral> suivis ;
	@OneToMany(mappedBy ="enseignant")
	private Set<SuiviEleve> suiviEleves ;
	
	public List<EcoleEnseignantMatiereClasse> getEcoleEnseignantMatiereClasses() {
		return ecoleEnseignantMatiereClasses;
	}
	public void setEcoleEnseignantMatiereClasses(List<EcoleEnseignantMatiereClasse> ecoleEnseignantMatiereClasses) {
		this.ecoleEnseignantMatiereClasses = ecoleEnseignantMatiereClasses;
	}
	public Set<SuiviGeneral> getSuivis() {
		return suivis;
	}
	public void setSuivis(Set<SuiviGeneral> suivis) {
		this.suivis = suivis;
	}
	public Enseignant(int id_enseignant, String nom, String prenoms, String telephone, String email, int type, int statut) {
		super();
		this.id_enseignant = id_enseignant;
		this.nom = nom;
		this.prenoms = prenoms;
		this.telephone = telephone;
		this.email = email;
		this.type = type;
		this.status = statut;
	}
	public Enseignant() {
		super();
	}
	public Enseignant(String nom, String prenoms, String telephone, int type) {
		super();
		this.nom = nom;
		this.prenoms = prenoms;
		this.telephone = telephone;
		this.type = type;
	}
	public Enseignant(String nom, String prenoms, String telephone, String email, int type) {
		super();
		this.nom = nom;
		this.prenoms = prenoms;
		this.telephone = telephone;
		this.email = email;
		this.type = type;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	
	public Set<Matiere> getMatieres() {
		return matieres;
	}
	
	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}
	public Set<SuiviEleve> getSuiviEleves() {
		return suiviEleves;
	}
	public void setSuiviEleves(Set<SuiviEleve> suiviEleves) {
		this.suiviEleves = suiviEleves;
	}
	

}
