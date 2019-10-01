package com.all4tic.suiviscolaire.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ecoleens_matcl")
public class EcoleEnseignantMatiereClasse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_ecolensmat ;
	@ManyToOne()
	private Matiere matiere;
	@ManyToOne()
	private Ecole ecole;
	@ManyToOne()
	private Enseignant enseignant ;
	@ManyToOne()
	private Classe classe ;
	@ManyToOne()
	private  Annee annee;
	private int statut=1;
	
	public EcoleEnseignantMatiereClasse(int id_ecolensmat, Matiere matiere, Ecole ecole, Enseignant enseignant,
			Classe classe) {
		super();
		this.id_ecolensmat = id_ecolensmat;
		this.matiere = matiere;
		this.ecole = ecole;
		this.enseignant = enseignant;
		this.classe = classe;
	}
	public EcoleEnseignantMatiereClasse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_ecolensmat() {
		return id_ecolensmat;
	}
	public void setId_ecolensmat(int id_ecolensmat) {
		this.id_ecolensmat = id_ecolensmat;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Ecole getEcole() {
		return ecole;
	}
	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Annee getAnnee() {
		return annee;
	}
	public void setAnnee(Annee annee) {
		this.annee = annee;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
	
	
}
