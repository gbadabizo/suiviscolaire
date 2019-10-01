package com.all4tic.suiviscolaire.utilities;

import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.Ecole;

public class EleveByClasse {
	private int idecole;
	private int idclasse ;
	private int idannee;
	public EleveByClasse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EleveByClasse(int idecole, int idclasse, int idannee) {
		super();
		this.idecole = idecole;
		this.idclasse = idclasse;
		this.idannee = idannee;
	}
	public int getIdecole() {
		return idecole;
	}
	public void setIdecole(int idecole) {
		this.idecole = idecole;
	}
	public int getIdclasse() {
		return idclasse;
	}
	public void setIdclasse(int idclasse) {
		this.idclasse = idclasse;
	}
	public int getIdannee() {
		return idannee;
	}
	public void setIdannee(int idannee) {
		this.idannee = idannee;
	}
	@Override
	public String toString() {
		return "EleveByClasse [idecole=" + idecole + ", idclasse=" + idclasse + ", idannee=" + idannee + "]";
	}
	
	
}
