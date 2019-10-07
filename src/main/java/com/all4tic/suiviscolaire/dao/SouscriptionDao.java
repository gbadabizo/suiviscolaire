package com.all4tic.suiviscolaire.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.suiviscolaire.entities.Souscription;
@Repository
public interface SouscriptionDao extends CrudRepository<Souscription, Integer> {

}
