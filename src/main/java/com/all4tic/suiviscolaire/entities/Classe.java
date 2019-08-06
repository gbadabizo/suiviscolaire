package com.all4tic.suiviscolaire.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="classe")
public class Classe implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id_classe ;
	@Column(length=50)
	private String libelle;
	@Column(length = 10)
	private String code ;
	
	private int status=1 ;
	@ManyToMany(cascade = {
	        CascadeType.REMOVE
	    })
	    @JoinTable(name = "classe_matiere",
	        joinColumns = @JoinColumn(name = "id_classe"),
	        inverseJoinColumns = @JoinColumn(name = "id_matiere")
	    )
	private Set<Matiere> Matieres = new HashSet<>();
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cycle")
    private Cycle cycle;
	
	public Classe()  {
		super();
		
	}
	@ManyToMany(cascade = {
	        CascadeType.REMOVE
	    })
	    @JoinTable(name = "ecole_classe",
	        joinColumns = @JoinColumn(name = "id_classe"),
	        inverseJoinColumns = @JoinColumn(name = "id_ecole")
	    )
	private Set<Ecole> ecoles = new HashSet<>();
	public Classe(int id_classe, String libelle, String code, int statut) {
		super();
		this.id_classe = id_classe;
		this.libelle = libelle;
		this.status = statut;
	}
	public Classe(String libelle) {
		super();
		this.libelle = libelle;
	}
	public int getId_classe() {
		return id_classe;
	}
	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int statut) {
		this.status = statut;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public Set<Ecole> getEcoles() {
		return ecoles;
	}
	public void setEcoles(Set<Ecole> ecoles) {
		this.ecoles = ecoles;
	}
	public Set<Matiere> getMatieres() {
		return Matieres;
	}
	public void setMatieres(Set<Matiere> matieres) {
		Matieres = matieres;
	}
	public Cycle getCycle() {
		return cycle;
	}
	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}
	
	
}
