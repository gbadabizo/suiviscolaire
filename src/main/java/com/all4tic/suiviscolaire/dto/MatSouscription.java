package com.all4tic.suiviscolaire.dto;

import java.util.List;

import com.all4tic.suiviscolaire.entities.Matiere;

public class MatSouscription {
	private int id_annee;
	private int id_eleve;
	private int id_classe;
	private int id_parent;
	private List<Matiere>matieres;
	public MatSouscription(int id_annee, int id_eleve, int id_classe, List<Matiere> matieres) {
		super();
		this.id_annee = id_annee;
		this.id_eleve = id_eleve;
		this.id_classe = id_classe;
		this.matieres = matieres;
	}
	public MatSouscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MatSouscription(int id_annee, int id_eleve, int id_classe, int id_parent, List<Matiere> matieres) {
		super();
		this.id_annee = id_annee;
		this.id_eleve = id_eleve;
		this.id_classe = id_classe;
		this.id_parent = id_parent;
		this.matieres = matieres;
	}
	
	public int getId_parent() {
		return id_parent;
	}
	public void setId_parent(int id_parent) {
		this.id_parent = id_parent;
	}
	public int getId_annee() {
		return id_annee;
	}
	public void setId_annee(int id_annee) {
		this.id_annee = id_annee;
	}
	public int getId_eleve() {
		return id_eleve;
	}
	public void setId_eleve(int id_eleve) {
		this.id_eleve = id_eleve;
	}
	public int getId_classe() {
		return id_classe;
	}
	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	@Override
	public String toString() {
		return "MatSouscription [id_annee=" + id_annee + ", id_eleve=" + id_eleve + ", id_classe=" + id_classe
				+ ", id_parent=" + id_parent + ", matieres=" + matieres + "]";
	}
	

}
