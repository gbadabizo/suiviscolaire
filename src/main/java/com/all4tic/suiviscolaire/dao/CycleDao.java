package com.all4tic.suiviscolaire.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.all4tic.suiviscolaire.entities.Cycle;

@Repository
public interface CycleDao extends CrudRepository<Cycle,Integer> {

}
