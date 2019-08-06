package com.all4tic.suiviscolaire.dao;


import com.all4tic.suiviscolaire.entities.Matiere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatiereDao extends CrudRepository<Matiere,Integer> {
	List<Matiere> findByStatus(int status);
}
