package com.all4tic.suiviscolaire.dto;

public class MatiereDto {
	private int id_matiere ;
	private String libelle ;
	private String code ;
	private String description;
	private int status=1;
	public MatiereDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatiereDto(int id_matiere, String libelle, String code, String description, int status) {
		super();
		this.id_matiere = id_matiere;
		this.libelle = libelle;
		this.code = code;
		this.description = description;
		this.status = status;
	}
	public int getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
