package com.all4tic.suiviscolaire.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.EleveClasseAnnee;
@Repository
public interface EleveClasseAnneeDao extends CrudRepository<EleveClasseAnnee, Long> {
		List<EleveClasseAnnee>findAllByEleveAndStatut(Eleve eleve, int statut);
		List<EleveClasseAnnee>findAllByClasseAndAnneeAndStatut(Classe classe, Annee annee, int statut);
}
