package com.all4tic.suiviscolaire.service;

import java.util.List;

import com.all4tic.suiviscolaire.entities.Eleve;

public interface EleveService {
    List<Eleve> listEleve();
    List<Eleve> getlistEleveByEcole(int idecole);
    Eleve save(Eleve el);
    Eleve getEleve(int ideleve);
}
