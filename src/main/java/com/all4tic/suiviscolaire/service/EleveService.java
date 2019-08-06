package com.all4tic.suiviscolaire.service;


import java.util.List;

import com.all4tic.suiviscolaire.entities.Eleve;

/**
 *  Service EleveService pour gérer les Elèves
 */
public interface EleveService {
	
	/**
	 * Enregistrer un élève
	 * @param eleve l'entité à enregistrer
	 * @return l'entité Eleve enregistré
	 */
	public Eleve save(Eleve eleve);
	

	public List<Eleve> findAllEleves();
	
	
	/**
	 * Retourne un élève à partir de son id
	 * @param id l'Id de l'eleve
	 * @return L'entité Eleve
	 */
	public Eleve findOne(Long id);
	
	
	/**
	 * Supprimer une entité Eleve à partir de son Id
	 * @param id est l'Id de l'entité en question
	 * @return
	 */
	public void delete(Long id);
	
	
}
