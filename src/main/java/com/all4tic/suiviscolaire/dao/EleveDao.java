package com.all4tic.suiviscolaire.dao;

import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.Eleve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveDao extends CrudRepository<Eleve, Long> {
	List<Eleve> findAllByEcoleAndStatut(Ecole ecole, int statut);
	List<Eleve> findAllByStatut(int statut);
	
}
