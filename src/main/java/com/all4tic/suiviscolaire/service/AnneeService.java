package com.all4tic.suiviscolaire.service;



import com.all4tic.suiviscolaire.entities.Annee;

import java.util.List;

public interface AnneeService {
	public Annee save(Annee a) ;
	public Annee getAnneById(int id);
	public List<Annee>listAnnee() ;
	public int delete(int id);

}
