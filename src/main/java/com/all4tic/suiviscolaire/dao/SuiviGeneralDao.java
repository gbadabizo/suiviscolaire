package com.all4tic.suiviscolaire.dao;

import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.entities.Matiere;
import com.all4tic.suiviscolaire.entities.SuiviGeneral;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiviGeneralDao extends CrudRepository<SuiviGeneral, Long> {
	List<SuiviGeneral> findAllByStatus(int statut) ;
	List<SuiviGeneral> findAllByEnseignantAndStatus(Enseignant enseignant ,int statut) ;
	List<SuiviGeneral> findAllByEnseignantAndAnneeAndStatus(Enseignant enseignant , Annee annee, int statut) ;
	List<SuiviGeneral> findAllByEnseignantAndAnneeAndClasseAndEcole(Enseignant enseignant , Annee annee,Classe classe,Ecole ecole) ;
	List<SuiviGeneral> findAllByEnseignantAndAnneeAndMatiereAndStatus(Enseignant enseignant , Annee annee,Matiere matiere, int statut) ;
	Page<SuiviGeneral> findAllByAnneeAndClasseAndEcoleAndStatusOrderByDatesuiviDesc( Annee annee,Classe classe,Ecole ecole,int statut, Pageable pageable) ;
}
/*
Pageable pageable = PageRequest.of(0, 10);
Page<Employee> page = employeeRepository.findAll(pageable);*/