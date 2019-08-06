package com.all4tic.suiviscolaire.service;



import com.all4tic.suiviscolaire.entities.Matiere;

import java.util.List;

public interface MatiereService {
	public Matiere save(Matiere a) ;
	public Matiere getMatiereById(int id);
	public List<Matiere>listMatiere() ;
	public int delete(int id);
}
