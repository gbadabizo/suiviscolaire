package com.all4tic.suiviscolaire.utilities;

import java.util.Date;

public class suiviEl {
	private Date datedebut ;
	private Date datefin;
	private int assiduite;
	private int retard ;
	private int exo_maison;
	private int absence;
	private String observation;
	private int idenseignant;
	private int idmatiere;
	private int idannee;
	private int idclasse;
	private int ideleve;
	public suiviEl(Date datedebut, Date datefin, int assiduite, int retard, int exo_maison, int absence,
			String observation, int idenseignant, int idmatiere, int idannee, int idclasse) {
		super();
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.assiduite = assiduite;
		this.retard = retard;
		this.exo_maison = exo_maison;
		this.absence = absence;
		this.observation = observation;
		this.idenseignant = idenseignant;
		this.idmatiere = idmatiere;
		this.idannee = idannee;
		this.idclasse = idclasse;
	}
	public suiviEl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public suiviEl(Date datedebut, Date datefin, int assiduite, int retard, int exo_maison, int absence,
			String observation, int idenseignant, int idmatiere, int idannee, int idclasse, int ideleve) {
		super();
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.assiduite = assiduite;
		this.retard = retard;
		this.exo_maison = exo_maison;
		this.absence = absence;
		this.observation = observation;
		this.idenseignant = idenseignant;
		this.idmatiere = idmatiere;
		this.idannee = idannee;
		this.idclasse = idclasse;
		this.ideleve = ideleve;
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
	public int getAssiduite() {
		return assiduite;
	}
	public void setAssiduite(int assiduite) {
		this.assiduite = assiduite;
	}
	public int getRetard() {
		return retard;
	}
	public void setRetard(int retard) {
		this.retard = retard;
	}
	public int getExo_maison() {
		return exo_maison;
	}
	public void setExo_maison(int exo_maison) {
		this.exo_maison = exo_maison;
	}
	public int getAbsence() {
		return absence;
	}
	public void setAbsence(int absence) {
		this.absence = absence;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public int getIdenseignant() {
		return idenseignant;
	}
	public void setIdenseignant(int idenseignant) {
		this.idenseignant = idenseignant;
	}
	public int getIdmatiere() {
		return idmatiere;
	}
	public void setIdmatiere(int idmatiere) {
		this.idmatiere = idmatiere;
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
	public int getIdeleve() {
		return ideleve;
	}
	public void setIdeleve(int ideleve) {
		this.ideleve = ideleve;
	}
	
}
