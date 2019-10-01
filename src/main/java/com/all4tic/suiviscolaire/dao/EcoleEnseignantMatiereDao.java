package com.all4tic.suiviscolaire.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.EcoleEnseignantMatiereClasse;
import com.all4tic.suiviscolaire.entities.Enseignant;
@Repository
public interface EcoleEnseignantMatiereDao extends CrudRepository<EcoleEnseignantMatiereClasse, Integer>{
	List<EcoleEnseignantMatiereClasse> findAllByEcoleAndClasseAndStatut(Ecole ecole, Classe classe,int statut);
	List<EcoleEnseignantMatiereClasse> findAllByEcoleAndStatut(Ecole ecole, int statut);
	List<EcoleEnseignantMatiereClasse> findAllByEcoleAndEnseignantAndAnneeAndStatut(Ecole ecole,Enseignant ens,Annee a, int statut);
	List<EcoleEnseignantMatiereClasse> findAllByEcoleAndEnseignantAndAnneeAndClasseAndStatut(Ecole ecole,Enseignant ens,Annee a, Classe c,int statut);
}
