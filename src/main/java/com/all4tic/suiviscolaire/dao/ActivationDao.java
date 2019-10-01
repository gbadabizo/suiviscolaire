package com.all4tic.suiviscolaire.dao;


import org.springframework.data.repository.CrudRepository;

import com.all4tic.suiviscolaire.entities.Activation;

public interface ActivationDao extends CrudRepository<Activation, Integer> {
    public Activation findActivationByIduserAndCode(int iduser, String code);
}
