package com.all4tic.suiviscolaire.service;


import com.all4tic.suiviscolaire.dao.ClasseDao;
import com.all4tic.suiviscolaire.entities.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseServiceImpl implements ClasseService {
	@Autowired
	private ClasseDao classeDao ;
	@Override
	public Classe save(Classe c) {
	
		return classeDao.save(c);
	}

	@Override
	public Classe getClasseById(int id) {
		
		return classeDao.findById(id).get();
	}

	@Override
	public List<Classe> listClasse() {
		int statut =1 ;
		List<Classe> list = classeDao.findByStatus(statut) ;
		return list;
	}

	@Override
	public int delete(int id) {
		int statut = 0 ;
		Classe c=	classeDao.findById(id).get();
		c.setStatus(statut);
		classeDao.save(c);
		return c.getStatus();
		
	}

}
