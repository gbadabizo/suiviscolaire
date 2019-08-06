package com.all4tic.suiviscolaire.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ecoleens_matcl")
public class EcoleEnseignantMatiereClasse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_ecolensmat ;
	private Matiere matiere;
	private Ecole ecole;
	private Enseignant enseigant ;
	private Classe classe ;
	private  Annee annee;
	private int statut=1;
	
	public EcoleEnseignantMatiereClasse(int id_ecolensmat, Matiere matiere, Ecole ecole, Enseignant enseigant,
			Classe classe) {
		super();
		this.id_ecolensmat = id_ecolensmat;
		this.matiere = matiere;
		this.ecole = ecole;
		this.enseigant = enseigant;
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
	public Enseignant getEnseigant() {
		return enseigant;
	}
	public void setEnseigant(Enseignant enseigant) {
		this.enseigant = enseigant;
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
