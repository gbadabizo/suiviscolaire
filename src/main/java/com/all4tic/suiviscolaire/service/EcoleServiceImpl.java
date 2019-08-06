package com.all4tic.suiviscolaire.service;


import com.all4tic.suiviscolaire.dao.EcoleDao;
import com.all4tic.suiviscolaire.entities.Ecole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcoleServiceImpl implements EcoleService{
	@Autowired
	private EcoleDao ecoleDao ;

	@Override
	public Ecole save(Ecole e) {
	
		return ecoleDao.save(e);
	}

	@Override
	public Ecole getEcoleById(int id) {
	
		return ecoleDao.findById(id).get();
	}

	@Override
	public List<Ecole> listEcole() {
		int statut= 1 ;
		List<Ecole> list = ecoleDao.findByStatus(statut);
		return list;
	}

	@Override
	public Integer delete(int id) {
		
		int statut=0 ;
		Ecole ecole = ecoleDao.findById(id).get();
		ecole.setStatus(statut);
		ecoleDao.save(ecole);
		return ecole.getStatus();
		
		
	}
	
}
