package com.all4tic.suiviscolaire.dto;

import java.util.Date;
import com.all4tic.suiviscolaire.entities.TypeSuivi;

public class SuiviGeneralDto {
	private Long id_suivi;
	private String titre;
	private String message;	
	private String fichier;
	private int status ;
	private Date datesuivi;
	private Date datedevoir;
	private Date datedebut;
	private String codematiere;
	private String libellematiere;
	private Date datefin;
	private int typesuivi;
	public SuiviGeneralDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuiviGeneralDto(Long id_suivi, String titre, String message, String fichier, int status, Date datesuivi,
			Date datedevoir, Date datedebut, Date datefin) {
		super();
		this.id_suivi = id_suivi;
		this.titre = titre;
		this.message = message;
		this.fichier = fichier;
		this.status = status;
		this.datesuivi = datesuivi;
		this.datedevoir = datedevoir;
		this.datedebut = datedebut;
		this.datefin = datefin;
		
	}
	
	
	
	public SuiviGeneralDto(Long id_suivi, String titre, String message, String fichier, int status, Date datesuivi,
			Date datedevoir, Date datedebut, String codematiere, String libellematiere, Date datefin, int typesuivi) {
		super();
		this.id_suivi = id_suivi;
		this.titre = titre;
		this.message = message;
		this.fichier = fichier;
		this.status = status;
		this.datesuivi = datesuivi;
		this.datedevoir = datedevoir;
		this.datedebut = datedebut;
		this.codematiere = codematiere;
		this.libellematiere = libellematiere;
		this.datefin = datefin;
		this.typesuivi = typesuivi;
	}
	
	public String getCodematiere() {
		return codematiere;
	}
	public void setCodematiere(String codematiere) {
		this.codematiere = codematiere;
	}
	public String getLibellematiere() {
		return libellematiere;
	}
	public void setLibellematiere(String libellematiere) {
		this.libellematiere = libellematiere;
	}
	public int getTypesuivi() {
		return typesuivi;
	}
	public void setTypesuivi(int typesuivi) {
		this.typesuivi = typesuivi;
	}
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
	public Date getDatedevoir() {
		return datedevoir;
	}
	public void setDatedevoir(Date datedevoir) {
		this.datedevoir = datedevoir;
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
