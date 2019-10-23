package com.all4tic.suiviscolaire.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.Parent;
import com.all4tic.suiviscolaire.entities.Souscription;
@Repository
public interface SouscriptionDao extends CrudRepository<Souscription, Integer> {
Souscription findByEleveAndClasseAndAnneeAndParentAndStatut(Eleve eleve, Classe classe ,Annee annee, Parent parent, int statut);
Souscription findByEleveAndParentAndStatut(Eleve eleve,  Parent parent, int statut);
}
