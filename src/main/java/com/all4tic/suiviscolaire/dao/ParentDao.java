package com.all4tic.suiviscolaire.dao;


import com.all4tic.suiviscolaire.entities.Parent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ParentDao extends CrudRepository<Parent, Long> {
		Parent findByNomAndTelephoneAndStatut(String nom, String telephone, int statut);
}
