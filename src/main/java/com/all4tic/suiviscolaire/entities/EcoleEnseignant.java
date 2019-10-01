package com.all4tic.suiviscolaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="ecole_enseignant")
public class EcoleEnseignant implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_ecolens ;
	@ManyToOne()
	private Ecole ecole;
	@ManyToOne()
	private Enseignant enseignant;
	private int status =1;
	public EcoleEnseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EcoleEnseignant(int id_ecolens, Ecole ecole, Enseignant enseignant, int status) {
		super();
		this.id_ecolens = id_ecolens;
		this.ecole = ecole;
		this.enseignant = enseignant;
		this.status = status;
	}
	public int getId_ecolens() {
		return id_ecolens;
	}
	public void setId_ecolens(int id_ecolens) {
		this.id_ecolens = id_ecolens;
	}
	public Ecole getEcole() {
		return ecole;
	}
	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	@JsonIgnore
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
