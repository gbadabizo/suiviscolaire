package com.all4tic.suiviscolaire.service;

import com.all4tic.suiviscolaire.dao.MatiereDao;
import com.all4tic.suiviscolaire.entities.Matiere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereServiceImpl implements MatiereService {
	@Autowired
	private MatiereDao matiereDao ;
	@Override
	public Matiere save(Matiere a) {
		
		return matiereDao.save(a);
	}

	@Override
	public Matiere getMatiereById(int id) {
		
		return matiereDao.findById(id).get();
	}

	@Override
	public List<Matiere> listMatiere() {
		int status = 1;
		List<Matiere> list = matiereDao.findByStatus(status);
		return list;
	}

	@Override
	public int delete(int id) {
		int status =0;
		Matiere mat = matiereDao.findById(id).get();
		mat.setStatus(status);
		matiereDao.save(mat);
		return mat.getStatus();
			
	}

}
