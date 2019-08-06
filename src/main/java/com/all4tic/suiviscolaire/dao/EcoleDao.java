package com.all4tic.suiviscolaire.dao;

import com.all4tic.suiviscolaire.entities.Ecole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcoleDao  extends CrudRepository<Ecole,Integer> {
	List<Ecole> findByStatus(int status);	
}
