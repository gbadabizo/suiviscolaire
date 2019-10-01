package com.all4tic.suiviscolaire.entities;

import java.util.Set;

public class ClasseMatiere {
	private Classe classe ;
	private Set<Matiere> matieres ;
	public ClasseMatiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClasseMatiere(Classe classe, Set<Matiere> matieres) {
		super();
		this.classe = classe;
		this.matieres = matieres;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Set<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}
	@Override
	public String toString() {
		return "ClasseMatiere [classe=" + classe + ", matieres=" + matieres + "]";
	}
	
	
}
