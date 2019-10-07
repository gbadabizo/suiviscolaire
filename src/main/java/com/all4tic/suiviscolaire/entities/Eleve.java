package com.all4tic.suiviscolaire.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date ;
import java.util.HashSet;
import java.util.List;
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
	private String telephone;
	private String matricule ;
	@Temporal(TemporalType.DATE)
	private Date datenaiss ;
	private int statut=1;
	@OneToMany(mappedBy ="eleve")
	private Set<SuiviEleve> suivis ;
	
	@ManyToMany(mappedBy = "eleves")
	private Set<Parent> parents = new HashSet<>();
	
	@ManyToOne
    Ecole ecole;
	@OneToMany(
			mappedBy="eleve",
	        cascade = CascadeType.REMOVE
	    )
	List<EleveClasseAnnee> eleveClasseAnnees ;
	public Eleve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Eleve(String nom, String prenoms, char sexe, String telephone, int statut) {
		this.nom = nom;
		this.prenoms = prenoms;
		this.sexe = sexe;
		
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
	

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
	public Date getDatenaiss() {
		return datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	@Override
	public String toString() {
		return "Eleve [id_eleve=" + id_eleve + ", nom=" + nom + ", prenoms=" + prenoms + ", sexe=" + sexe
				+ ", telephone=" + telephone + ", matricule=" + matricule + ", datenaiss=" + datenaiss + ", statut="
				+ statut + ", parents=" + parents + ", ecole=" + ecole + "]";
	}

	public Set<SuiviEleve> getSuivis() {
		return suivis;
	}

	public void setSuivis(Set<SuiviEleve> suivis) {
		this.suivis = suivis;
	}

	public List<EleveClasseAnnee> getEleveClasseAnnees() {
		return eleveClasseAnnees;
	}

	public void setEleveClasseAnnees(List<EleveClasseAnnee> eleveClasseAnnees) {
		this.eleveClasseAnnees = eleveClasseAnnees;
	}

	
}
