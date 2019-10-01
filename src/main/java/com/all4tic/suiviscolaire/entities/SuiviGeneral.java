package com.all4tic.suiviscolaire.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

public class SuiviGeneral implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_suivi;
	
	private String titre;
	
	private String message;
	
	private String fichier;
	private int status=1 ;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date datesuivi= new Date();
	@Temporal(value = TemporalType.DATE)
	private Date datedevoir;
	@Temporal(value = TemporalType.DATE)
	private Date datedebut;
	@Temporal(value = TemporalType.DATE)
	private Date datefin;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private TypeSuivi typeSuivi;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Enseignant enseignant ;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Ecole ecole;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Classe classe ;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Matiere matiere ;
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Annee annee ;
	public Long getId_suivi() {
		return id_suivi;
	}

	public void setId_suivi(Long id_suivi) {
		this.id_suivi = id_suivi;
	}

	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String getFichier() {
		return fichier;
	}
	
	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	
	public Date getDatesuivi() {
		return datesuivi;
	}
	
	public void setDatesuivi(Date datesuivi) {
		this.datesuivi = datesuivi;
	}
	
	public TypeSuivi getTypeSuivi() {
		return typeSuivi;
	}
	
	public void setTypeSuivi(TypeSuivi typeSuivi) {
		this.typeSuivi = typeSuivi;
	}

	public Date getDatedevoir() {
		return datedevoir;
	}

	public void setDatedevoir(Date datedevoir) {
		this.datedevoir = datedevoir;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
	
	
	
}
