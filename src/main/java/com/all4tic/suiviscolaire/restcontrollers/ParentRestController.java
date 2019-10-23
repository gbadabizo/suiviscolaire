package com.all4tic.suiviscolaire.restcontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.all4tic.suiviscolaire.dao.AnneeDao;
import com.all4tic.suiviscolaire.dao.ParentDao;
import com.all4tic.suiviscolaire.dao.SouscriptionDao;
import com.all4tic.suiviscolaire.dao.SuiviEleveDao;
import com.all4tic.suiviscolaire.dto.EleveDto;
import com.all4tic.suiviscolaire.dto.SuviEleveDto;
import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.Parent;
import com.all4tic.suiviscolaire.entities.Souscription;
import com.all4tic.suiviscolaire.entities.SuiviEleve;
import com.all4tic.suiviscolaire.security.User;
import com.all4tic.suiviscolaire.security.UserRepository;
import com.all4tic.suiviscolaire.service.EleveService;
import com.all4tic.suiviscolaire.utilities.Reponse;
import com.all4tic.suiviscolaire.utilities.Utility;

@RestController
@RequestMapping("/parent")
@CrossOrigin
public class ParentRestController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ParentDao parentDao;
	@Autowired
	private SouscriptionDao souscriptionDao;
	@Autowired
	private SuiviEleveDao  suiviEleveDao ;
	@Autowired
	private EleveService eleveService;
	@Autowired
	private AnneeDao anneeDao;
	@GetMapping("/eleves/{userid}")
	public Reponse getAllEleve(@PathVariable int userid) {
		Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		User user = userRepository.findById((long) userid).get();
		Optional<Parent> p = parentDao.findById((long) user.getIsparent());
		if(p.isPresent()) {
			Parent parent =p.get();
			Set<Eleve>eleves = parent.getEleves();
			List<EleveDto> eldtos= new ArrayList<>();
			for(Eleve eleve : eleves ) {
				Souscription  souscription= souscriptionDao.findByEleveAndParentAndStatut(eleve, parent, 1);
				if(souscription !=null) {
				 EleveDto eldto= new EleveDto();
	    		 eldto.setId_eleve(eleve.getId_eleve());
	    		 eldto.setNom(eleve.getNom());
	    		 eldto.setPrenoms(eleve.getPrenoms());
	    		 eldto.setMatricule(eleve.getMatricule());
	    		 eldto.setDatenaiss(eleve.getDatenaiss());
	    		 eldto.setSexe(eleve.getSexe());
	    		 eldto.setEcole(eleve.getEcole().getNom());
	    		 eldto.setClasse(souscription.getClasse().getCode());
	    		 eldto.setAnnee(souscription.getAnnee().getLibelle());
	    		 eldtos.add(eldto);
				}
			}
			reponse.setCode(Utility.SUCCESSFUL_CODE);
			reponse.setMessage("SUCCES");
			reponse.setDatas(eldtos);
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
	   @GetMapping("/suivis/{ideleve}/{annee}/{page}")
	   public Reponse getAllSuivis(@PathVariable int ideleve,@PathVariable String annee, @PathVariable int page) {
		   Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		   Eleve eleve = eleveService.getEleve(ideleve);
		   Annee an = anneeDao.findByLibelleAndStatus(annee, 1);
		   Pageable pageable = PageRequest.of(page, 10);
		   Page<SuiviEleve> suivis = suiviEleveDao.findAllByEleveAndAnneeAndStatusOrderByDatefinDesc(eleve, an, 1, pageable);
		   if(suivis!=null) {
			    reponse.setCode(Utility.SUCCESSFUL_CODE);
				reponse.setMessage("SUCCES");
				List<SuviEleveDto> suivisdto= new ArrayList<>();
				for(SuiviEleve s : suivis ) {
					SuviEleveDto sdto = new SuviEleveDto();
					sdto.setAbsence(s.getAbsence());
					sdto.setAssiduite(s.getAssiduite());
					sdto.setClasse(s.getClasse().getCode());
					sdto.setCodeMatiere(s.getMatiere().getLibelle());
					sdto.setExo_maison(s.getExo_maison());
					sdto.setDatedebut(s.getDatedebut());
					sdto.setDatefin(s.getDatefin());
					sdto.setObservation(s.getObservation());
					suivisdto.add(sdto);
				}
				reponse.setDatas(suivisdto);
		   }
		   return reponse ;
	   }
	   
}
