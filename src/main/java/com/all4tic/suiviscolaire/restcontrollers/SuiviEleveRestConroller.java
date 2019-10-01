package com.all4tic.suiviscolaire.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.all4tic.suiviscolaire.dao.AnneeDao;
import com.all4tic.suiviscolaire.dao.EcoleEnseignantMatiereDao;
import com.all4tic.suiviscolaire.dao.EleveClasseAnneeDao;
import com.all4tic.suiviscolaire.dao.SuiviEleveDao;
import com.all4tic.suiviscolaire.dao.SuiviGeneralDao;
import com.all4tic.suiviscolaire.dto.SuviEleveDto;
import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.entities.Matiere;
import com.all4tic.suiviscolaire.entities.SuiviEleve;
import com.all4tic.suiviscolaire.service.ClasseService;
import com.all4tic.suiviscolaire.service.EcoleService;
import com.all4tic.suiviscolaire.service.EleveService;
import com.all4tic.suiviscolaire.service.EnseignantService;
import com.all4tic.suiviscolaire.service.MatiereService;
import com.all4tic.suiviscolaire.utilities.Reponse;

import com.all4tic.suiviscolaire.utilities.Utility;
import com.all4tic.suiviscolaire.utilities.suiviEl;

@RestController
@RequestMapping("/api/suivi")
@CrossOrigin 
public class SuiviEleveRestConroller {
	@Autowired
	private EnseignantService enseignantService ;
	@Autowired
	private EcoleEnseignantMatiereDao ecoleEnseignantMatiereDao;
	@Autowired
	private EcoleService ecoleservice ; 
	@Autowired
	private EleveService eleveService ;
	@Autowired
	private ClasseService classeService ;
	@Autowired
	private AnneeDao anneeDao ;
	@Autowired
	private SuiviEleveDao suiviEleveDao;
	@Autowired
	private MatiereService matiereService ;
	@PostMapping("/eleve")
	public Reponse saveSuivi(@RequestBody suiviEl suiviel) {
		Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		if(suiviel != null) {
			SuiviEleve suiviEleve = new SuiviEleve();
			suiviEleve.setAnnee(anneeDao.findById(suiviel.getIdannee()).get());
			suiviEleve.setClasse(classeService.getClasseById(suiviel.getIdclasse()));
			suiviEleve.setEnseignant(enseignantService.getEnseignantById(suiviel.getIdenseignant()));
			suiviEleve.setMatiere(matiereService.getMatiereById(suiviel.getIdmatiere()));
			suiviEleve.setEleve(eleveService.getEleve(suiviel.getIdeleve()));
			suiviEleve.setAbsence(suiviel.getAbsence());
			suiviEleve.setAssiduite(suiviel.getAssiduite());
			suiviEleve.setDatedebut(suiviel.getDatedebut());
			suiviEleve.setDatefin(suiviel.getDatefin());
			suiviEleve.setRetard(suiviel.getRetard());
			suiviEleve.setExo_maison(suiviel.getExo_maison());
			suiviEleve.setObservation(suiviel.getObservation());
			SuiviEleve suiviElev=suiviEleveDao.save(suiviEleve);
			if(suiviElev != null) {
				SuviEleveDto suiviElDto= new SuviEleveDto();
				suiviElDto.setId_suivi(suiviElev.getId_suivi());
				suiviElDto.setAbsence(suiviElev.getAbsence());
				suiviElDto.setAssiduite(suiviElev.getAssiduite());
				suiviElDto.setDatedebut(suiviElev.getDatedebut());
				suiviElDto.setDatefin(suiviElev.getDatefin());
				suiviElDto.setRetard(suiviElev.getRetard());
				suiviElDto.setExo_maison(suiviElev.getExo_maison());
				suiviElDto.setObservation(suiviElev.getObservation());
				reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",suiviElDto);
			}
			
		}
		return reponse;
	}
	private Reponse getReponse(int code, String message, Object o) {
		Reponse reponse = new Reponse();
		reponse.setCode(code);
		reponse.setMessage(message);
		reponse.setDatas(o);
		return reponse ;
	}
	@GetMapping("/eleve/{ideleve}/{idenseignant}/{idannee}")
	public Reponse getSuivisByEleve(@PathVariable int ideleve, @PathVariable int idenseignant, @PathVariable int idannee) {
		Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		Eleve eleve = eleveService.getEleve(ideleve);
		Enseignant enseignant = enseignantService.getEnseignantById(idenseignant);
		Annee annee = anneeDao.findById(idannee).get();
		List<SuiviEleve> suivisEleves = suiviEleveDao.findAllByEleveAndEnseignantAndAnneeOrderByDatefinDesc(eleve, enseignant, annee);
		List<SuviEleveDto>suivis = new ArrayList<>();
		if(!suivisEleves.isEmpty()) {
			for(SuiviEleve s :suivisEleves) {
				if(s.getStatus() > 0) {
					SuviEleveDto suiviElDto= new SuviEleveDto();
					suiviElDto.setId_suivi(s.getId_suivi());
					suiviElDto.setAbsence(s.getAbsence());
					suiviElDto.setAssiduite(s.getAssiduite());
					suiviElDto.setDatedebut(s.getDatedebut());
					suiviElDto.setDatefin(s.getDatefin());
					suiviElDto.setRetard(s.getRetard());
					suiviElDto.setExo_maison(s.getExo_maison());
					suiviElDto.setObservation(s.getObservation());
					suiviElDto.setStatus(s.getStatus());
					suiviElDto.setDatesuivi(s.getDatesuivi());
					Matiere matiere=s.getMatiere();
					suiviElDto.setLibMatiere(matiere.getLibelle());
					suiviElDto.setCodeMatiere(matiere.getCode());
					suivis.add(suiviElDto);
				}
				
				
			}
			reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",suivis);
		}
		return reponse ;
	}
}
