package com.all4tic.suiviscolaire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class SouscriptionMatiere {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id_sm ;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matiere")
	private Matiere matiere;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_souscription")
	private Souscription souscription;
	private Date datedebut;
	private Date datefin;
	private int statut=1;
	public SouscriptionMatiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SouscriptionMatiere(int id_sm, Matiere matiere, Souscription souscription, Date datedebut, Date datefin,
			int statut) {
		super();
		this.id_sm = id_sm;
		this.matiere = matiere;
		this.souscription = souscription;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.statut = statut;
	}
	public int getId_sm() {
		return id_sm;
	}
	public void setId_sm(int id_sm) {
		this.id_sm = id_sm;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Souscription getSouscription() {
		return souscription;
	}
	public void setSouscription(Souscription souscription) {
		this.souscription = souscription;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
	
}
