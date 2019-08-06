package com.all4tic.suiviscolaire.service;



import com.all4tic.suiviscolaire.entities.Classe;

import java.util.List;

public interface ClasseService {
	public Classe save(Classe c) ;
	public Classe getClasseById(int id);
	public List<Classe>listClasse() ;
	public int delete(int id);
}
