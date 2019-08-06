package com.all4tic.suiviscolaire.service;


import com.all4tic.suiviscolaire.dao.EleveDao;
import com.all4tic.suiviscolaire.entities.Eleve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EleveServiceImpl implements EleveService {
	
	private final Logger log = LoggerFactory.getLogger(EleveServiceImpl.class);
	
	private EleveDao eleveDao;
	

	
	/**
	 * Enregistrer un élève
	 * @param eleve l'entité à enregistrer
	 * @return l'entité enregistré
	 */
	@Override
	public Eleve save(Eleve eleve) {
		log.debug("Request to save Eleve : {}", eleve);
		Eleve result = eleveDao.save(eleve);
		return result;
	}
	
	/**
	 * Retourner touts les élèves
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Eleve> findAllEleves() {
		log.debug("Request to get all Eleves");
		return (List<Eleve>) eleveDao.findAll();
	}
	
	/**
	 * Retourne un élève par son id
	 *
	 * @param id l'Id de l'eleve
	 * @return l'entité retourné
	 */
	@Override
	@Transactional(readOnly = true)
	public Eleve findOne(Long id) {
		log.debug("Request to get Eleve : {}", id);
		return eleveDao.findOneEleveWithEager(id);
	}
	
	
	/**
	 * Supprimer un élève par son id
	 * @param id est l'Id de l'entité en question
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Eleve : {}", id);
		eleveDao.deleteById(id);
	}
}
