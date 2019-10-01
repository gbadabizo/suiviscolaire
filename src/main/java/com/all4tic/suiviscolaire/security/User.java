package com.all4tic.suiviscolaire.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String username ;
	@Column(nullable=false)
	private String password;
	private String nom;
	private String prenoms;
	@Column(unique = true)
	private String telephone;
	private int status;
	private int active =1;
	private int isparent;
	private int isenseignant;
	private String roles;
	private String permissions;
	public User(String username, String password, String roles, String permissions) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.permissions = permissions;
	}
	public User() {
		super();
		
	}
	
	public User(long id, String username, String password, String telephone, int status, int active, String roles,
			String permissions) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.status = status;
		this.active = active;
		this.roles = roles;
		this.permissions = permissions;
	}
	
	public User(long id, String username, String password, String nom, String prenoms, String telephone, int status,
			int active, int isparent, int isenseignant, String roles, String permissions) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenoms = prenoms;
		this.telephone = telephone;
		this.status = status;
		this.active = active;
		this.isparent = isparent;
		this.isenseignant = isenseignant;
		this.roles = roles;
		this.permissions = permissions;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	public int getIsparent() {
		return isparent;
	}
	public void setIsparent(int isparent) {
		this.isparent = isparent;
	}
	public int getIsenseignant() {
		return isenseignant;
	}
	public void setIsenseignant(int isenseignant) {
		this.isenseignant = isenseignant;
	}
	public List<String> getRoleList(){
		if(this.roles.length()>0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new  ArrayList<>();
	}
	public List<String> getPermissionsList(){
		if(this.permissions.length()>0) {
			return Arrays.asList(this.permissions.split(","));
		}
		return new  ArrayList<>();
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
