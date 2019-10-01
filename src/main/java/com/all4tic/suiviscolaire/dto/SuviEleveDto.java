package com.all4tic.suiviscolaire.dto;

import java.util.Date;

public class SuviEleveDto {
	private  long id_suivi ;
	private int assiduite;
	private int retard ;
	private int exo_maison;
	private int absence;
	private String observation;
	private int status ;
	private Date datesuivi ;
	private Date datedebut;
	private Date datefin;
	private String libMatiere;
	private String codeMatiere;
	public SuviEleveDto(long id_suivi, int assiduite, int retard, int exo_maison, int absence, String observation,
			int status, Date datesuivi, Date datedebut, Date datefin) {
		super();
		this.id_suivi = id_suivi;
		this.assiduite = assiduite;
		this.retard = retard;
		this.exo_maison = exo_maison;
		this.absence = absence;
		this.observation = observation;
		this.status = status;
		this.datesuivi = datesuivi;
		this.datedebut = datedebut;
		this.datefin = datefin;
	}
	
	public SuviEleveDto(long id_suivi, int assiduite, int retard, int exo_maison, int absence, String observation,
			int status, Date datesuivi, Date datedebut, Date datefin, String libMatiere, String codeMatiere) {
		super();
		this.id_suivi = id_suivi;
		this.assiduite = assiduite;
		this.retard = retard;
		this.exo_maison = exo_maison;
		this.absence = absence;
		this.observation = observation;
		this.status = status;
		this.datesuivi = datesuivi;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.libMatiere = libMatiere;
		this.codeMatiere = codeMatiere;
	}

	public SuviEleveDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId_suivi() {
		return id_suivi;
	}
	public void setId_suivi(long id_suivi) {
		this.id_suivi = id_suivi;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDatesuivi() {
		return datesuivi;
	}
	public void setDatesuivi(Date datesuivi) {
		this.datesuivi = datesuivi;
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

	public String getLibMatiere() {
		return libMatiere;
	}

	public void setLibMatiere(String libMatiere) {
		this.libMatiere = libMatiere;
	}

	public String getCodeMatiere() {
		return codeMatiere;
	}

	public void setCodeMatiere(String codeMatiere) {
		this.codeMatiere = codeMatiere;
	}
	
}
