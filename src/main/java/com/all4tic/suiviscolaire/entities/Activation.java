package com.all4tic.suiviscolaire.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Activation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id_activation ;
    private String code ;
    private long dateactivation =  new Date().getTime();
    private int status = 0;
    private int iduser ;

    public Activation() {
    }

    public Activation(int id_activation, String code, long dateactivation, int status, int iduser) {
		super();
		this.id_activation = id_activation;
		this.code = code;
		this.dateactivation = dateactivation;
		this.status = status;
		this.iduser = iduser;
	}



	public int getId_activation() {
        return id_activation;
    }

    public void setId_activation(int id_activation) {
        this.id_activation = id_activation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getDateactivation() {
        return dateactivation;
    }

    public void setDateactivation(long dateactivation) {
        this.dateactivation = dateactivation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	@Override
	public String toString() {
		return "Activation [id_activation=" + id_activation + ", code=" + code + ", dateactivation=" + dateactivation
				+ ", status=" + status + ", iduser=" + iduser + "]";
	}

    
}
