package com.all4tic.suiviscolaire.dao;


import com.all4tic.suiviscolaire.entities.Annee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnneeDao extends CrudRepository<Annee,Integer> {
	List<Annee> findByStatus(int status);
	
}
