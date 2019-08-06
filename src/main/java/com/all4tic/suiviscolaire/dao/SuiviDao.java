package com.all4tic.suiviscolaire.dao;

import com.all4tic.suiviscolaire.entities.Suivi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiviDao extends CrudRepository<Suivi, Long> {
}
