package com.all4tic.suiviscolaire.service;


import com.all4tic.suiviscolaire.dao.EnseignantDao;
import com.all4tic.suiviscolaire.entities.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantServiceImpl implements EnseignantService {
	@Autowired
	private EnseignantDao enseignantDao ;
	@Override
	public Enseignant save(Enseignant a) {
		
		return enseignantDao.save(a);
	}

	@Override
	public Enseignant getEnseignantById(int id) {
	
		return enseignantDao.findById(id).get();
	}

	@Override
	public List<Enseignant> listEnseignant() {
		int status = 1 ;
		List<Enseignant> list = enseignantDao.findByStatus(status);
				
		return list ;
	}

	@Override
	public int delete(int id) {
		Enseignant ens = enseignantDao.findById(id).get();
		int status =0;
		ens.setStatus(status);
		enseignantDao.save(ens);
		return ens.getStatus();
		
	}

}
