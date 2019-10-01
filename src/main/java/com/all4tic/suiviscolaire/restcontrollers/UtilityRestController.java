package com.all4tic.suiviscolaire.restcontrollers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.all4tic.suiviscolaire.dao.AnneeDao;
import com.all4tic.suiviscolaire.dto.AnneeDto;
import com.all4tic.suiviscolaire.dto.ClasseDto;
import com.all4tic.suiviscolaire.dto.EcoleDto;
import com.all4tic.suiviscolaire.dto.EleveDto;
import com.all4tic.suiviscolaire.dto.EnseignantDto;
import com.all4tic.suiviscolaire.dto.MatiereDto;
import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.entities.Matiere;
import com.all4tic.suiviscolaire.service.ClasseService;
import com.all4tic.suiviscolaire.service.EcoleService;
import com.all4tic.suiviscolaire.service.EleveService;
import com.all4tic.suiviscolaire.service.EnseignantService;
import com.all4tic.suiviscolaire.utilities.Reponse;
import com.all4tic.suiviscolaire.utilities.Utility;

@RestController
@RequestMapping("/api/utility")
@CrossOrigin 
public class UtilityRestController {
	@Autowired
	private EnseignantService enseignantService ;
	@Autowired 
	EcoleService ecoleService ;
	@Autowired
	ClasseService classeService ;
	@Autowired
	EleveService eleveService;
	@Autowired
	AnneeDao anneeDao ;
	@GetMapping("/enseignant/{id}")
	public Reponse getEnseignant(@PathVariable int id) {
		Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		Enseignant e = enseignantService.getEnseignantById(id);
		EnseignantDto edto =new EnseignantDto();
		if(e!=null) {
			edto.setId_enseignant(e.getId_enseignant());
			edto.setNom(e.getNom());
			edto.setPrenoms(e.getPrenoms());
			edto.setTelephone(e.getTelephone());
			edto.setEmail(e.getEmail());
			edto.setStatus(e.getStatus());
			Set<Matiere>matieres =e.getMatieres();
			Set<MatiereDto> matieresDto= new HashSet<>();
			for(Matiere m : matieres) {
				MatiereDto mdto = new MatiereDto();
				mdto.setCode(m.getCode());
				mdto.setId_matiere(m.getId_matiere());
				mdto.setLibelle(m.getLibelle());
				mdto.setDescription(m.getDescription());
				mdto.setStatus(m.getStatus());
				matieresDto.add(mdto);
			}
			edto.setMatieres(matieresDto);
			reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",edto);
		}
		return reponse ;
				
		}
	@GetMapping("/ecole/{id}")
	public Reponse getEcole(@PathVariable int id) {
		Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		Ecole ecole = ecoleService.getEcoleById(id);
		if(ecole !=null) {
			EcoleDto ecoledto = new EcoleDto();
			ecoledto.setId_ecole(ecole.getId_ecole());
			ecoledto.setNom(ecole.getNom());
			ecoledto.setTelephone(ecole.getTelephone());
			ecoledto.setVille(ecole.getVille());
			ecoledto.setQuartier(ecole.getQuartier());
			ecoledto.setAdresse(ecole.getAdresse());
			ecoledto.setEmail(ecole.getEmail());
			ecoledto.setStatus(ecole.getStatus());
			reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",ecoledto);
		}
		return reponse ;
	}
	@GetMapping("/classe/{id}")
	public Reponse getClasse(@PathVariable int id) {
		Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		Classe c = classeService.getClasseById(id);
		if(c!=null) {
			ClasseDto cl = new ClasseDto();
			cl.setId_classe(c.getId_classe());
			cl.setCode(c.getCode());
			cl.setLibelle(c.getLibelle());
			cl.setStatus(c.getStatus());
			reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",cl);
			
		}
		return reponse ;
	}
	@GetMapping("/annee/{id}")
		public Reponse getAnnee(@PathVariable int id) {
		Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
			Annee annee = anneeDao.findById(id).get();
			if(annee !=null) {
				AnneeDto anneeDto = new AnneeDto();
				anneeDto.setId_annee(annee.getId_annee());
				anneeDto.setLibelle(annee.getLibelle());
				anneeDto.setDate_debut(annee.getDate_debut());
				anneeDto.setDate_fin(annee.getDate_fin());
				anneeDto.setStatus(annee.getStatus());
				reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",anneeDto);
			}
			return reponse ;
	}
	@GetMapping("/annees")
	public Reponse getAnnees() {
	Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		List<Annee> annees = anneeDao.findByStatus(1);
		if(!annees.isEmpty()) {
			List<AnneeDto> anneesDto=new ArrayList<>();
			for(Annee annee : annees) {
			AnneeDto anneeDto = new AnneeDto();
			anneeDto.setId_annee(annee.getId_annee());
			anneeDto.setLibelle(annee.getLibelle());
			anneeDto.setDate_debut(annee.getDate_debut());
			anneeDto.setDate_fin(annee.getDate_fin());
			anneesDto.add(anneeDto);
			}
			reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",anneesDto);
		}
		return reponse ;
}
	private Reponse getReponse(int code, String message, Object o) {
		Reponse reponse = new Reponse();
		reponse.setCode(code);
		reponse.setMessage(message);
		reponse.setDatas(o);
		return reponse ;
	}
	@GetMapping("/eleve/{id}")
	public Reponse getEleve(@PathVariable int id) {
		Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		Eleve el = eleveService.getEleve(id) ;
		if(el!=null) {
			EleveDto eldto = new EleveDto();
			eldto.setId_eleve(el.getId_eleve());
			eldto.setNom(el.getNom());
			eldto.setPrenoms(el.getPrenoms());
			eldto.setDatenaiss(el.getDatenaiss());
			eldto.setSexe(el.getSexe());
			eldto.setMatricule(el.getMatricule());
			eldto.setTelephone(el.getTelephone());
			eldto.setStatut(el.getStatus());
			reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES",eldto);
		}
		return reponse ;
	}
}
