package com.all4tic.suiviscolaire.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.all4tic.suiviscolaire.entities.SouscriptionMatiere;

@Repository
public interface SouscriptionMatiereDao extends CrudRepository<SouscriptionMatiere, Integer>{

}
