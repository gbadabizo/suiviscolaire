package com.all4tic.suiviscolaire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SuiviEleve  implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private  long id_suivi ;
	private int assiduite;
	private int retard ;
	private int exo_maison;
	private int absence;
	private String observation;
	private int status=1 ;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date datesuivi= new Date();
	@Temporal(value = TemporalType.DATE)
	private Date datedebut;
	@Temporal(value = TemporalType.DATE)
	private Date datefin;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Enseignant enseignant ;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Eleve eleve;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Classe classe ;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Matiere matiere ;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Annee annee ;
	
	public SuiviEleve(long id_suivi, int assiduite, int retard, int exo_maison, int absence, String observation,
			int status, Date datesuivi, Date datedebut, Date datefin, Enseignant enseignant, Eleve eleve, Classe classe,
			Matiere matiere, Annee annee) {
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
		this.enseignant = enseignant;
		this.eleve = eleve;
		this.classe = classe;
		this.matiere = matiere;
		this.annee = annee;
	}
	
	public SuiviEleve() {
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
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Annee getAnnee() {
		return annee;
	}
	public void setAnnee(Annee annee) {
		this.annee = annee;
	}
	
}
