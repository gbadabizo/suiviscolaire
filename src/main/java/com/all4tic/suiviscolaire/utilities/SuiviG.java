package com.all4tic.suiviscolaire.utilities;

import java.util.Date;

public class SuiviG {
	private String titre;
	private String message;
	private Object fileexo;
	private Date datedebut ;
	private Date datefin;
	private int idecole;
	private int idenseignant;
	private int idmatiere;
	private int idannee;
	private int idclasse;
	private Date datedevoir;
	private int idtypesuivi;
	public SuiviG() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuiviG(String titre, String message, Date datedebut, Date datefin, int idecole,
			int idenseignant, int idmatiere, int idannee, int idclasse, Date datedevoir) {
		super();
		this.titre = titre;
		this.message = message;
	
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.idecole = idecole;
		this.idenseignant = idenseignant;
		this.idmatiere = idmatiere;
		this.idannee = idannee;
		this.idclasse = idclasse;
		this.datedevoir = datedevoir;
	}
	
	public SuiviG(String titre, String message, Date datedebut, Date datefin, int idecole,
			int idenseignant, int idmatiere, int idannee, int idclasse, Date datedevoir, int idtypesuivi) {
		super();
		this.titre = titre;
		this.message = message;
	
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.idecole = idecole;
		this.idenseignant = idenseignant;
		this.idmatiere = idmatiere;
		this.idannee = idannee;
		this.idclasse = idclasse;
		this.datedevoir = datedevoir;
		this.idtypesuivi = idtypesuivi;
	}
	
	public Object getFileexo() {
		return fileexo;
	}
	public void setFileexo(Object fileexo) {
		this.fileexo = fileexo;
	}
	public SuiviG(String titre, String message, Object fileexo, Date datedebut, Date datefin, int idecole,
			int idenseignant, int idmatiere, int idannee, int idclasse, Date datedevoir, int idtypesuivi) {
		super();
		this.titre = titre;
		this.message = message;
		this.fileexo = fileexo;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.idecole = idecole;
		this.idenseignant = idenseignant;
		this.idmatiere = idmatiere;
		this.idannee = idannee;
		this.idclasse = idclasse;
		this.datedevoir = datedevoir;
		this.idtypesuivi = idtypesuivi;
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
	public Date getDatedevoir() {
		return datedevoir;
	}
	public void setDatedevoir(Date datedevoir) {
		this.datedevoir = datedevoir;
	}
	public int getIdtypesuivi() {
		return idtypesuivi;
	}
	public void setIdtypesuivi(int idtypesuivi) {
		this.idtypesuivi = idtypesuivi;
	}
	@Override
	public String toString() {
		return "SuiviG [titre=" + titre + ", message=" + message + ", fileexo=" + fileexo + ", datedebut=" + datedebut
				+ ", datefin=" + datefin + ", idecole=" + idecole + ", idenseignant=" + idenseignant + ", idmatiere="
				+ idmatiere + ", idannee=" + idannee + ", idclasse=" + idclasse + ", datedevoir=" + datedevoir
				+ ", idtypesuivi=" + idtypesuivi + "]";
	}
	
	
}
