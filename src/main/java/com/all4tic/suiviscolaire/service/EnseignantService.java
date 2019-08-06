package com.all4tic.suiviscolaire.service;



import com.all4tic.suiviscolaire.entities.Enseignant;

import java.util.List;

public interface EnseignantService {
	public Enseignant save(Enseignant a) ;
	public Enseignant getEnseignantById(int id);
	public List<Enseignant>listEnseignant() ;
	public int delete(int id);
}
