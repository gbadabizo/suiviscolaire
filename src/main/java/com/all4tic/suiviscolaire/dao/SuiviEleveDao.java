package com.all4tic.suiviscolaire.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.entities.Matiere;
import com.all4tic.suiviscolaire.entities.SuiviEleve;

public interface SuiviEleveDao extends CrudRepository<SuiviEleve, Long> {
	List<SuiviEleve>findAllByEleveAndAnneeAndStatus(Eleve eleve,Annee annee, int status);
	List<SuiviEleve>findAllByEleveAndEnseignantAndAnneeAndMatiereAndStatus(Eleve eleve,Enseignant enseignant, Annee annee,Matiere matiere, int status);
	List<SuiviEleve>findAllByEleveAndEnseignantAndAnneeOrderByDatefinDesc(Eleve eleve,Enseignant enseignant, Annee annee);
	Page<SuiviEleve>findAllByEleveAndAnneeAndStatusOrderByDatefinDesc(Eleve eleve,Annee annee, int status,Pageable pageable);
}
