package com.all4tic.suiviscolaire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id_message ;
	private String contenu;
	private Date datemessage=new Date();
	private int sender;
	private int receiver;
	private int status=0;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int id_message, String contenu, Date datemessage, int sender, int receiver) {
		super();
		this.id_message = id_message;
		this.contenu = contenu;
		this.datemessage = datemessage;
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public Message(int id_message, String contenu, Date datemessage, int sender, int receiver, int status) {
		super();
		this.id_message = id_message;
		this.contenu = contenu;
		this.datemessage = datemessage;
		this.sender = sender;
		this.receiver = receiver;
		this.status = status;
	}
	public int getId_message() {
		return id_message;
	}
	public void setId_message(int id_message) {
		this.id_message = id_message;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDatemessage() {
		return datemessage;
	}
	public void setDatemessage(Date datemessage) {
		this.datemessage = datemessage;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
