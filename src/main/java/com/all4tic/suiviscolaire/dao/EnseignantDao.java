package com.all4tic.suiviscolaire.dao;


import com.all4tic.suiviscolaire.entities.Enseignant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantDao extends CrudRepository<Enseignant,Integer> {
	List<Enseignant> findByStatus(int status);
}
