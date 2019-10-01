package com.all4tic.suiviscolaire.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.EcoleEnseignant;
import com.all4tic.suiviscolaire.entities.Enseignant;
@Repository
public interface EcoleEnseignantDao extends CrudRepository<EcoleEnseignant, Integer> {
	List<EcoleEnseignant>  findAllByEnseignant(Enseignant enseignant);
	List<EcoleEnseignant> findAllByEcole(Ecole ecole);
	EcoleEnseignant findByEcole(Ecole ecole);
}
