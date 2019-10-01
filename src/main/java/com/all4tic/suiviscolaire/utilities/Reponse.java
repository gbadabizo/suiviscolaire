package com.all4tic.suiviscolaire.utilities;

public class Reponse {
	int code;
	String message ;
	Object Datas ;
	public Reponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reponse(int code, String message, Object datas) {
		super();
		this.code = code;
		this.message = message;
		Datas = datas;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getDatas() {
		return Datas;
	}
	public void setDatas(Object datas) {
		Datas = datas;
	}
	
	
}
