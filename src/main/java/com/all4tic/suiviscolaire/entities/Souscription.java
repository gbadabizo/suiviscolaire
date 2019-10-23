package com.all4tic.suiviscolaire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Souscription implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id_souscription ;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_eleve")
	private Eleve eleve;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_annee")
	private Annee annee;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_classe")
	private Classe classe;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parent")
	private Parent parent;
	private Date dateSouscription = new Date();
	private int statut=1;
	public Souscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Souscription(int id_souscription, Eleve eleve, Annee annee, Classe classe, Date dateSouscription) {
		super();
		this.id_souscription = id_souscription;
		this.eleve = eleve;
		this.annee = annee;
		this.classe = classe;
		this.dateSouscription = dateSouscription;
	}
	
	public Souscription(int id_souscription, Eleve eleve, Annee annee, Classe classe, Date dateSouscription,
			int statut) {
		super();
		this.id_souscription = id_souscription;
		this.eleve = eleve;
		this.annee = annee;
		this.classe = classe;
		this.dateSouscription = dateSouscription;
		this.statut = statut;
	}
	
	public Souscription(int id_souscription, Eleve eleve, Annee annee, Classe classe, Parent parent,
			Date dateSouscription, int statut) {
		super();
		this.id_souscription = id_souscription;
		this.eleve = eleve;
		this.annee = annee;
		this.classe = classe;
		this.parent = parent;
		this.dateSouscription = dateSouscription;
		this.statut = statut;
	}
	
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public int getId_souscription() {
		return id_souscription;
	}
	public void setId_souscription(int id_souscription) {
		this.id_souscription = id_souscription;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Annee getAnnee() {
		return annee;
	}
	public void setAnnee(Annee annee) {
		this.annee = annee;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Date getDateSouscription() {
		return dateSouscription;
	}
	public void setDateSouscription(Date dateSouscription) {
		this.dateSouscription = dateSouscription;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "Souscription [id_souscription=" + id_souscription + ", eleve=" + eleve + ", annee=" + annee
				+ ", classe=" + classe + ", parent=" + parent.getNom() + ", dateSouscription=" + dateSouscription + ", statut="
				+ statut + "]";
	}
	
}
