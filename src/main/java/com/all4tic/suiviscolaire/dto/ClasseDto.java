package com.all4tic.suiviscolaire.dto;


public class ClasseDto {
			
			private int id_classe ;
			private String libelle;
			private String code ;
			private int status=1 ;
			public ClasseDto(int id_classe, String libelle, String code, int status) {
				super();
				this.id_classe = id_classe;
				this.libelle = libelle;
				this.code = code;
				this.status = status;
			}
			public ClasseDto() {
				super();
				// TODO Auto-generated constructor stub
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
			public String getCode() {
				return code;
			}
			public void setCode(String code) {
				this.code = code;
			}
			public int getStatus() {
				return status;
			}
			public void setStatus(int status) {
				this.status = status;
			}
			
	
}
