package com.all4tic.suiviscolaire.restcontrollers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.all4tic.suiviscolaire.dao.AnneeDao;
import com.all4tic.suiviscolaire.dao.EcoleEnseignantMatiereDao;
import com.all4tic.suiviscolaire.dao.EleveClasseAnneeDao;
import com.all4tic.suiviscolaire.dao.SuiviGeneralDao;
import com.all4tic.suiviscolaire.dao.TypeSuiviDao;
import com.all4tic.suiviscolaire.dto.ClasseDto;
import com.all4tic.suiviscolaire.dto.EcoleDto;
import com.all4tic.suiviscolaire.dto.EleveDto;
import com.all4tic.suiviscolaire.dto.SuiviGeneralDto;
import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.EcoleEnseignant;
import com.all4tic.suiviscolaire.entities.EcoleEnseignantMatiereClasse;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.EleveClasseAnnee;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.entities.SuiviGeneral;
import com.all4tic.suiviscolaire.security.User;
import com.all4tic.suiviscolaire.security.UserRepository;
import com.all4tic.suiviscolaire.service.ClasseService;
import com.all4tic.suiviscolaire.service.EcoleService;
import com.all4tic.suiviscolaire.service.EnseignantService;
import com.all4tic.suiviscolaire.service.MatiereService;
import com.all4tic.suiviscolaire.service.StorageService;
import com.all4tic.suiviscolaire.utilities.EleveByClasse;
import com.all4tic.suiviscolaire.utilities.ListSuivi;
import com.all4tic.suiviscolaire.utilities.Reponse;
import com.all4tic.suiviscolaire.utilities.SuiviG;
import com.all4tic.suiviscolaire.utilities.Utility;

@RestController
@RequestMapping("/api/enseignant")
@CrossOrigin(origins = "*")
public class EnseignantRestController {
	@Autowired
	private EnseignantService enseignantService ;
	@Autowired
	private EcoleEnseignantMatiereDao ecoleEnseignantMatiereDao;
	@Autowired
	private EcoleService ecoleservice ; 
	@Autowired
	private ClasseService classeService ;
	 @Autowired
	  StorageService storageService;
	@Autowired
	private AnneeDao anneeDao ;
	@Autowired
	private EleveClasseAnneeDao eleveClasseAnneeDao ;
	@Autowired
	private SuiviGeneralDao suiviGeneralDao ;
	@Autowired
	private MatiereService matiereService ;
	@Autowired
	private TypeSuiviDao typeSuiviDao;
	@Autowired
	private UserRepository userRepository;
	// renvoie la liste des ecole dans lesquelle l'enseignant intervient
	@GetMapping("/ecoles")
	public Reponse getEcoles(Principal user) {
		User u = userRepository.findByUsername(user.getName());
		int idens= u.getIsenseignant();
		Reponse reponse = new Reponse();
		reponse.setCode(Utility.FAILLURE_CODE);
		reponse.setMessage("ECHEC");
		reponse.setDatas(null);
		List<EcoleDto> ecoles = new ArrayList<>();
		Enseignant  enseignant = enseignantService.getEnseignantById(idens);
		if(enseignant !=null) {
			List<EcoleEnseignant> ecoleEnseignants = enseignant.getEcoleEnseignants();
			if(!ecoleEnseignants.isEmpty()) {
				for( EcoleEnseignant eg : ecoleEnseignants) {
					EcoleDto ecoledto = new EcoleDto();
					ecoledto.setId_ecole(eg.getEcole().getId_ecole());
					ecoledto.setNom(eg.getEcole().getNom());
					ecoledto.setTelephone(eg.getEcole().getTelephone());
					ecoledto.setVille(eg.getEcole().getVille());
					ecoledto.setQuartier(eg.getEcole().getQuartier());
					ecoledto.setAdresse(eg.getEcole().getAdresse());
					ecoledto.setEmail(eg.getEcole().getEmail());
					ecoledto.setStatus(eg.getEcole().getStatus());
					ecoles.add(ecoledto);
				}
				reponse.setCode(Utility.SUCCESSFUL_CODE);
				reponse.setMessage("SUCCES");
				reponse.setDatas(ecoles);
			}
		}
		return reponse ;
	}
	@GetMapping("/classes/{idecole}/{idens}/{idannee}")
	public Reponse getClasses(@PathVariable int idecole, @PathVariable int idens , @PathVariable int idannee) {
		Reponse reponse = new Reponse();
		reponse.setCode(Utility.FAILLURE_CODE);
		reponse.setMessage("ECHEC");
		reponse.setDatas(null);
		List<ClasseDto> classes = new ArrayList<>();
		Ecole ecole = ecoleservice.getEcoleById(idecole);
		Enseignant enseignant = enseignantService.getEnseignantById(idens);
		Annee annee = anneeDao.findById(idannee).get();
		List<EcoleEnseignantMatiereClasse>  ecoleEnseignantMatiereClasses = ecoleEnseignantMatiereDao.findAllByEcoleAndEnseignantAndAnneeAndStatut(ecole, enseignant, annee, 1);
		if(!ecoleEnseignantMatiereClasses.isEmpty()) {
			for(EcoleEnseignantMatiereClasse em : ecoleEnseignantMatiereClasses) {
				ClasseDto cl = new ClasseDto();
				cl.setId_classe(em.getClasse().getId_classe());
				cl.setCode(em.getClasse().getCode());
				cl.setLibelle(em.getClasse().getLibelle());
				cl.setStatus(em.getClasse().getStatus());
				classes.add(cl);
			}
			reponse.setCode(Utility.SUCCESSFUL_CODE);
			reponse.setMessage("SUCCES");
			reponse.setDatas(classes);
		}
		return reponse;
	}

	@PostMapping("/eleves")
	public Reponse getEleveByAnneeByEcoleByClasse(@RequestBody EleveByClasse eleveByClasse){
		Reponse reponse = new Reponse();
		reponse.setCode(Utility.FAILLURE_CODE);
		reponse.setMessage("ECHEC");
		reponse.setDatas(null);
		System.out.println(eleveByClasse);
		if(eleveByClasse != null) {
			Ecole ecole = ecoleservice.getEcoleById(eleveByClasse.getIdecole());
			Classe classe = classeService.getClasseById(eleveByClasse.getIdclasse());
			Annee annee = anneeDao.findById(eleveByClasse.getIdannee()).get();
			List<EleveClasseAnnee> eleveClasseAnnees = eleveClasseAnneeDao.findAllByClasseAndAnneeAndStatut(classe, annee, 1);
			List<EleveDto>eleves=new ArrayList<>();
			for(EleveClasseAnnee elc : eleveClasseAnnees ) {
				Eleve el = elc.getEleve();
				if(el.getEcole().equals(ecole)) {
					EleveDto eldto = new EleveDto();
					eldto.setId_eleve(el.getId_eleve());
					eldto.setNom(el.getNom());
					eldto.setPrenoms(el.getPrenoms());
					eldto.setDatenaiss(el.getDatenaiss());
					eldto.setSexe(el.getSexe());
					eldto.setMatricule(el.getMatricule());
					eldto.setTelephone(el.getTelephone());
					eldto.setStatut(el.getStatus());
					eleves.add(eldto);
				}
					
			}
			reponse.setCode(Utility.SUCCESSFUL_CODE);
			reponse.setMessage("SUCCES");
			reponse.setDatas(eleves);
		}
		return reponse ;
	}
	@PostMapping("/suivigeneral")
	public Reponse saveSuiviGeneral(@RequestBody SuiviG suivig) {
		Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		if(suivig != null) {
			System.out.println("........-----------exo-------"+suivig.toString());
			SuiviGeneral suiviGeneral = new SuiviGeneral();
			suiviGeneral.setTitre(suivig.getTitre());
			suiviGeneral.setMessage(suivig.getMessage());
			suiviGeneral.setAnnee(anneeDao.findById(suivig.getIdannee()).get());
			suiviGeneral.setClasse(classeService.getClasseById(suivig.getIdclasse()));
			suiviGeneral.setEnseignant(enseignantService.getEnseignantById(suivig.getIdenseignant()));
			suiviGeneral.setEcole(ecoleservice.getEcoleById(suivig.getIdecole()));
			suiviGeneral.setMatiere(matiereService.getMatiereById(suivig.getIdmatiere()));
			suiviGeneral.setDatedebut(suivig.getDatedebut());
			suiviGeneral.setDatefin(suivig.getDatefin());
			suiviGeneral.setTypeSuivi(typeSuiviDao.findById(suivig.getIdtypesuivi()).get());
			if(suivig.getDatedevoir()!=null)
				suiviGeneral.setDatedevoir(suivig.getDatedevoir());
			if(suivig.getFileexo()!=null) {
				storageService.init();
				 storageService.store((MultipartFile) suivig.getFileexo());
				System.out.println("........-----------exo-------"+suivig.getFileexo());
			}
			SuiviGeneral suiviSav =  suiviGeneralDao.save(suiviGeneral);
			if(suiviSav!=null) {
				SuiviGeneralDto suiviGeneralDto= new SuiviGeneralDto();
				suiviGeneralDto.setId_suivi(suiviSav.getId_suivi());
				suiviGeneralDto.setMessage(suiviSav.getMessage());
				suiviGeneralDto.setTitre(suiviSav.getTitre());
				suiviGeneralDto.setFichier(suiviSav.getFichier());
				suiviGeneralDto.setDatedebut(suiviSav.getDatedebut());
				suiviGeneralDto.setDatefin(suiviSav.getDatefin());
				suiviGeneralDto.setTypesuivi(suiviSav.getTypeSuivi().getId_type());
				suiviGeneralDto.setCodematiere(suiviSav.getMatiere().getCode());
				suiviGeneralDto.setLibellematiere(suiviSav.getMatiere().getLibelle());
				suiviGeneralDto.setDatedevoir(suiviSav.getDatedevoir());
				suiviGeneralDto.setDatesuivi(suiviSav.getDatesuivi());
				reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",suiviGeneralDto);
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
		@PostMapping("/suivigenerals")
		public Reponse getSuiviGeneral(@RequestBody ListSuivi listsuivi) {
			Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
			Ecole ecole = ecoleservice.getEcoleById(listsuivi.getIdecole());
			Annee annee = anneeDao.findById(listsuivi.getIdannee()).get();
			Enseignant enseignant = enseignantService.getEnseignantById(listsuivi.getIdenseignant());
			Classe classe = classeService.getClasseById(listsuivi.getIdclasse());
			List<SuiviGeneral> suivis=suiviGeneralDao
					.findAllByEnseignantAndAnneeAndClasseAndEcole(enseignant, annee, classe, ecole);
			List<SuiviGeneralDto> suiviGeneralDtos= new ArrayList<>();
			if(!suivis.isEmpty()) {
				for(SuiviGeneral s : suivis) {
					if(s.getStatus() >0) {
					SuiviGeneralDto suiviGeneralDto= new SuiviGeneralDto();
					suiviGeneralDto.setId_suivi(s.getId_suivi());
					suiviGeneralDto.setMessage(s.getMessage());
					suiviGeneralDto.setTitre(s.getTitre());
					suiviGeneralDto.setFichier(s.getFichier());
					suiviGeneralDto.setDatedebut(s.getDatedebut());
					suiviGeneralDto.setDatefin(s.getDatefin());
					suiviGeneralDto.setStatus(s.getStatus());
					suiviGeneralDto.setDatedevoir(s.getDatedevoir());
					suiviGeneralDto.setDatesuivi(s.getDatesuivi());
					suiviGeneralDto.setCodematiere(s.getMatiere().getCode());
					suiviGeneralDto.setLibellematiere(s.getMatiere().getLibelle());
					suiviGeneralDto.setTypesuivi(s.getTypeSuivi().getId_type());
					suiviGeneralDtos.add(suiviGeneralDto);
					}
				}
				reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",suiviGeneralDtos);
			}
			return reponse;
		}
		/*
		 * fonction permettant de publier une publication status=2
		 * fonction permettant de 
		 */
		@GetMapping("/suivigeneral/{idsuivig}/{status}")
		public Reponse changeSuiviStatus(@PathVariable int idsuivig , @PathVariable int status) {
			Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
			Optional<SuiviGeneral> suivi = suiviGeneralDao.findById((long)idsuivig);
			if(suivi.isPresent()) {
				SuiviGeneral suivig = suivi.get();
				suivig.setStatus(status);
				suiviGeneralDao.save(suivig);
				SuiviGeneralDto suiviGeneralDto= new SuiviGeneralDto();
				suiviGeneralDto.setId_suivi(suivig.getId_suivi());
				suiviGeneralDto.setMessage(suivig.getMessage());
				suiviGeneralDto.setTitre(suivig.getTitre());
				suiviGeneralDto.setFichier(suivig.getFichier());
				suiviGeneralDto.setDatedebut(suivig.getDatedebut());
				suiviGeneralDto.setDatefin(suivig.getDatefin());
				suiviGeneralDto.setDatedevoir(suivig.getDatedevoir());
				suiviGeneralDto.setDatesuivi(suivig.getDatesuivi());
				suiviGeneralDto.setCodematiere(suivig.getMatiere().getCode());
				suiviGeneralDto.setLibellematiere(suivig.getMatiere().getLibelle());
				suiviGeneralDto.setTypesuivi(suivig.getTypeSuivi().getId_type());
				reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",suiviGeneralDto);
			}
			return reponse;
		}
	

}
