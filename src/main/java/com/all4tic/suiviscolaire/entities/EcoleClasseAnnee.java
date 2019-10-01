package com.all4tic.suiviscolaire.entities;

public class EcoleClasseAnnee {
		 private Ecole ecole;
		 private Annee annee;
		 private Classe classe ;
		 public EcoleClasseAnnee(Ecole ecole, Annee annee, Classe classe) {
			super();
			this.ecole = ecole;
			this.annee = annee;
			this.classe = classe;
		}
		public EcoleClasseAnnee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Ecole getEcole() {
			return ecole;
		}
		public void setEcole(Ecole ecole) {
			this.ecole = ecole;
		}
		public Annee getAnnee() {
			return annee;
		}
		public void setAnnee(Annee annee) {
			this.annee = annee;
		}
		public Classe getClasse() {
			return classe;
		}
		public void setClasse(Classe classe) {
			this.classe = classe;
		}
		
		 
}
