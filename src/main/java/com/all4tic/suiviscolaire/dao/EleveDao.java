package com.all4tic.suiviscolaire.dao;

import com.all4tic.suiviscolaire.entities.Eleve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveDao extends CrudRepository<Eleve, Long> {
	
	@Query("select distinct eleve from Eleve eleve left join fetch eleve.parents")
	List<Eleve> findAllEleveWithEager();
	
	@Query("select eleve from Eleve eleve left join fetch eleve.parents where eleve.id =:id")
	Eleve findOneEleveWithEager(@Param("id") Long id);
}
