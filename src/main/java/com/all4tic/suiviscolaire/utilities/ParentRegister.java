package com.all4tic.suiviscolaire.utilities;

public class ParentRegister {
	private String nom;
	private String prenoms;
	private String telephone;
	private int isparent = 1;
	
	public ParentRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ParentRegister(String nom, String prenoms, String telephone, int isparent) {
		super();
		this.nom = nom;
		this.prenoms = prenoms;
		this.telephone = telephone;
		this.isparent = isparent;
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
	public int getIsparent() {
		return isparent;
	}
	public void setIsparent(int isparent) {
		this.isparent = isparent;
	}
	
}
