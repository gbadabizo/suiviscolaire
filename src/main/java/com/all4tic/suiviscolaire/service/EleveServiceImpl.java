package com.all4tic.suiviscolaire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.all4tic.suiviscolaire.dao.EcoleDao;
import com.all4tic.suiviscolaire.dao.EleveDao;
import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.Eleve;
@Service
public class EleveServiceImpl implements EleveService {
	@Autowired
	private EleveDao eleveDao ;
	@Autowired
	private EcoleService ecoleService ;
	@Override
	public List<Eleve> listEleve() {
		
		return (List<Eleve>) eleveDao.findAllByStatut(1) ;
	}
	@Override
	public List<Eleve> getlistEleveByEcole(int idecole) {
		Ecole ecole = ecoleService.getEcoleById(idecole);
		return eleveDao.findAllByEcoleAndStatut(ecole, 1);
	}
	@Override
	public Eleve save(Eleve el) {
		// TODO Auto-generated method stub
		return eleveDao.save(el);
	}
	@Override
	public Eleve getEleve(int ideleve) {
		
		return eleveDao.findById((long)ideleve).get();
	}

}
