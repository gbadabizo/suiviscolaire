package com.all4tic.suiviscolaire.service;



import com.all4tic.suiviscolaire.entities.Ecole;

import java.util.List;

public interface EcoleService  {
	public Ecole save(Ecole e) ;
	public Ecole getEcoleById(int id);
	public List<Ecole>listEcole() ;
	public Integer delete(int id);
}
