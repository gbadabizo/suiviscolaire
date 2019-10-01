package com.all4tic.suiviscolaire.entities;

import java.util.List;
import java.util.Set;

public class EnseignantMatiere {
	private Enseignant enseignant ;
	private Set<Matiere> matieres;
	public EnseignantMatiere(Enseignant enseignant, Set<Matiere> matieres) {
		super();
		this.enseignant = enseignant;
		this.matieres = matieres;
	}
	public EnseignantMatiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Set<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	

}
