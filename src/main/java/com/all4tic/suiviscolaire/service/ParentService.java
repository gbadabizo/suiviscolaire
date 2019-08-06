package com.all4tic.suiviscolaire.service;

import com.all4tic.suiviscolaire.entities.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface Service pour gérer les parents
 */
public interface ParentService {
	
	/**
	 * Enregistrer un parent
	 *
	 * @param parent : l'entité à enregistrer
	 * @return l'entité enregistré est retourné
	 */
	Parent save(Parent parent);
	
	/**
	 * Retourne un Parent par son Id.
	 *
	 * @param id l'id de l'entité
	 * @return l'entité correspondant à l'Id
	 */
	Parent findOne(Long id);
	
	
	/**
	 * Supprimer l'entité dont l'id est fourni
	 *
	 * @param id l'id de l'entité
	 */
	void delete(Long id);
	
}
