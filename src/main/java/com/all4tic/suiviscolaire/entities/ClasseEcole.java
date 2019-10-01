package com.all4tic.suiviscolaire.entities;

import java.util.Set;

public class ClasseEcole {
	private Ecole ecole ;
	private Set<Classe> classes ;
	public ClasseEcole(Ecole ecole, Set<Classe> classes) {
		super();
		this.ecole = ecole;
		this.classes = classes;
	}
	public ClasseEcole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ecole getEcole() {
		return ecole;
	}
	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	public Set<Classe> getClasses() {
		return classes;
	}
	public void setClasses(Set<Classe> classes) {
		this.classes = classes;
	}
	
	
}
