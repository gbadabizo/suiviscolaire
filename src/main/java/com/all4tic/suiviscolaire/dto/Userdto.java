package com.all4tic.suiviscolaire.dto;

public class Userdto {
	private String username;
	private String password;
	public Userdto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Userdto() {
		super();
		// TODO Auto-generated constructor stub
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
	
}
