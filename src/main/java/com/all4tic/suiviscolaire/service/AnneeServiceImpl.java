package com.all4tic.suiviscolaire.service;


import com.all4tic.suiviscolaire.dao.AnneeDao;
import com.all4tic.suiviscolaire.entities.Annee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneeServiceImpl implements AnneeService {
	@Autowired
	private AnneeDao anneeDao ;
	@Override
	public Annee save(Annee a) {
	
		return anneeDao.save(a);
	}

	@Override
	public Annee getAnneById(int id) {
		
		return anneeDao.findById(id).get();
	}
	@Override
	public List<Annee> listAnnee() {
	int	statut =1;
		List<Annee> list = anneeDao.findByStatus(statut);
	
		return list ;
	}

		@Override
	public int delete(int id) {
		int statut = 0 ;
	Annee annee=	anneeDao.findById(id).get();
	annee.setStatus(statut);
	anneeDao.save(annee);
	return annee.getStatus();
		
	}
  

}
