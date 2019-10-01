package com.all4tic.suiviscolaire.utilities;

public class ListSuivi {
	private int idecole;
	private int idenseignant;
	private int idannee;
	private int idclasse;
	public ListSuivi(int idecole, int idenseignant, int idannee, int idclasse) {
		super();
		this.idecole = idecole;
		this.idenseignant = idenseignant;
		this.idannee = idannee;
		this.idclasse = idclasse;
	}
	public ListSuivi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdecole() {
		return idecole;
	}
	public void setIdecole(int idecole) {
		this.idecole = idecole;
	}
	public int getIdenseignant() {
		return idenseignant;
	}
	public void setIdenseignant(int idenseignant) {
		this.idenseignant = idenseignant;
	}
	public int getIdannee() {
		return idannee;
	}
	public void setIdannee(int idannee) {
		this.idannee = idannee;
	}
	public int getIdclasse() {
		return idclasse;
	}
	public void setIdclasse(int idclasse) {
		this.idclasse = idclasse;
	}
	
}
