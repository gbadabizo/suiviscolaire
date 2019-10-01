package com.all4tic.suiviscolaire.dao;

import com.all4tic.suiviscolaire.entities.TypeSuivi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TypeSuiviDao extends CrudRepository<TypeSuivi, Integer> {

}
