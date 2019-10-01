package com.all4tic.suiviscolaire.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EleveClasseAnnee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_eleveclannee;
	@ManyToOne
	private Classe classe ;
	@ManyToOne
	private Eleve eleve ;
	@ManyToOne
	private Annee annee;
	private int statut=1;
	public EleveClasseAnnee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EleveClasseAnnee(Long id_eleveclannee, Classe classe, Eleve eleve, Annee annee) {
		super();
		this.id_eleveclannee = id_eleveclannee;
		this.classe = classe;
		this.eleve = eleve;
		this.annee = annee;
	}
	public Long getId_eleveclannee() {
		return id_eleveclannee;
	}
	public void setId_eleveclannee(Long id_eleveclannee) {
		this.id_eleveclannee = id_eleveclannee;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
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
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	} 
	
	
}
