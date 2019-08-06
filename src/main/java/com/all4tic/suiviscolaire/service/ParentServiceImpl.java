package com.all4tic.suiviscolaire.service;

import com.all4tic.suiviscolaire.dao.ParentDao;
import com.all4tic.suiviscolaire.entities.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implémentation de ParentMetier pour gérer les parent
 */
public class ParentServiceImpl implements ParentService {
	
	private final Logger log = LoggerFactory.getLogger(ParentServiceImpl.class);
	
	private ParentDao parentDao;
	
	public ParentServiceImpl(ParentDao parentDao) {
		this.parentDao = parentDao;
	}
	
	
	/**
	 * Enregistrer un parent
	 * @param parent : l'entité à enregistrer
	 * @return l'entité enregistré
	 */
	@Override
	public Parent save(Parent parent) {
		log.debug("Requête pour enregistrer Parent : {}", parent);
		Parent result = parentDao.save(parent);
		return result;
	}
	

	/**
	 * Retourner un parent par son Id
	 * @param id l'id de l'entité
	 * @return the Paent entity
	 */
	@Override
	@Transactional(readOnly = true)
	public Parent findOne(Long id) {
		log.debug("Requête pour obtenir un  Parent : {}", id);
		return parentDao.findOneWithEagerRelationships(id);
	}
	
	/**
	 * Supprimer une entité Parent
	 * @param id l'id de l'entité
	 */
	@Override
	public void delete(Long id) {
		log.debug("Requête pour supprimer un Parent: {}", id);
		parentDao.deleteById(id);
	}
}
