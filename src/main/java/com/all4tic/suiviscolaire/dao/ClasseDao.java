package com.all4tic.suiviscolaire.dao;


import com.all4tic.suiviscolaire.entities.Classe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseDao extends CrudRepository<Classe,Integer> {
	List<Classe> findByStatus(int status);
}
