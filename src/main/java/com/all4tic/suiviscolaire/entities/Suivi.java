package com.all4tic.suiviscolaire.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Suivi implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_suivi;
	
	private String titre;
	
	private String message;
	
	private Double note;
	
	private String fichier;
	
	@Temporal(value = TemporalType.DATE)
	private Date datesuivi;
	
	@ManyToOne(optional = false)
	private TypeSuivi typeSuivi;
	
	@ManyToMany(mappedBy = "suivis")
	@JsonIgnore
	private List<Parent> parents = new ArrayList<>();
	
	public Suivi(String titre, String message, Double note, String fichier, Date datesuivi) {
		this.titre = titre;
		this.message = message;
		this.note = note;
		this.fichier = fichier;
		this.datesuivi = datesuivi;
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
	
	public Double getNote() {
		return note;
	}
	
	public void setNote(Double note) {
		this.note = note;
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
	
	public List<Parent> getParents() {
		return parents;
	}
	
	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}
	
	@Override
	public String toString() {
		return "Suivi{" +
			"id=" + id_suivi +
			", titre='" + titre + '\'' +
			", message='" + message + '\'' +
			", note=" + note +
			", fichier='" + fichier + '\'' +
			", datesuivi=" + datesuivi +
			'}';
	}
}
