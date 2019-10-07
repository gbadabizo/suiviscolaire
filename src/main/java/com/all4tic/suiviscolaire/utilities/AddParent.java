package com.all4tic.suiviscolaire.utilities;

public class AddParent {
 private int id_ecole;
 private int id_user;
 private int id_annee;
 private String matricule;
public AddParent(int id_ecole, int id_user, int id_annee, String matricule) {
			super();
			this.id_ecole = id_ecole;
			this.id_user = id_user;
			this.id_annee = id_annee;
			this.matricule = matricule;
		}
		public AddParent() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getId_ecole() {
			return id_ecole;
		}
		public void setId_ecole(int id_ecole) {
			this.id_ecole = id_ecole;
		}
		public int getId_user() {
			return id_user;
		}
		public void setId_user(int id_user) {
			this.id_user = id_user;
		}
		public int getId_annee() {
			return id_annee;
		}
		public void setId_annee(int id_annee) {
			this.id_annee = id_annee;
		}
		public String getMatricule() {
			return matricule;
		}
		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}
		 
}
