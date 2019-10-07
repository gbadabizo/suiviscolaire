package com.all4tic.suiviscolaire.restcontrollers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.all4tic.suiviscolaire.dao.ActivationDao;
import com.all4tic.suiviscolaire.dao.AnneeDao;
import com.all4tic.suiviscolaire.dao.EleveClasseAnneeDao;
import com.all4tic.suiviscolaire.dao.EleveDao;
import com.all4tic.suiviscolaire.dao.ParentDao;
import com.all4tic.suiviscolaire.dto.AnneeDto;
import com.all4tic.suiviscolaire.dto.ClasseDto;
import com.all4tic.suiviscolaire.dto.EcoleDto;
import com.all4tic.suiviscolaire.dto.EleveDto;
import com.all4tic.suiviscolaire.dto.MatiereDto;
import com.all4tic.suiviscolaire.entities.Activation;
import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.EcoleEnseignant;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.EleveClasseAnnee;
import com.all4tic.suiviscolaire.entities.Matiere;
import com.all4tic.suiviscolaire.entities.Parent;
import com.all4tic.suiviscolaire.security.User;
import com.all4tic.suiviscolaire.security.UserPrincipalDetailsService;
import com.all4tic.suiviscolaire.security.UserRepository;
import com.all4tic.suiviscolaire.service.ClasseService;
import com.all4tic.suiviscolaire.service.EcoleService;
import com.all4tic.suiviscolaire.service.EleveService;
import com.all4tic.suiviscolaire.utilities.AddParent;
import com.all4tic.suiviscolaire.utilities.ParentRegister;
import com.all4tic.suiviscolaire.utilities.Reponse;
import com.all4tic.suiviscolaire.utilities.Utility;
import com.all4tic.suiviscolaire.utilities.SendSms;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationRestService {
	@Autowired
	private UserPrincipalDetailsService userPrincipalDetailsService ;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder ;
	@Autowired
	private ActivationDao activationDao;
	@Autowired
	private AnneeDao anneeDao ;
	@Autowired
	private EcoleService ecoleservice ;
	@Autowired 
	private EleveDao eleveDao;
	@Autowired
	private EleveClasseAnneeDao eleveClasseAnneeDao;
	@Autowired
	private ClasseService classeService;
	@Autowired
	private ParentDao parentDao;
	
	 @GetMapping("/login")
	    public User login(Principal user) {
		 			
		 return userRepository.findByUsername(user.getName());      
	    }
	    @RequestMapping("/user")
	    public Principal user(HttpServletRequest request) {
	        String authToken = request.getHeader("Authorization")
	          .substring("Basic".length()).trim();
	        return () ->  new String(Base64.getDecoder()
	          .decode(authToken)).split(":")[0];
	    }
	    @PostMapping("/register")
	    public Reponse register(@RequestBody ParentRegister p) {
		    User us = userRepository.findByUsername(p.getTelephone()); // on cherche user
			Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
		    if(us==null) {
		    	User u = new User();
		    	u.setNom(p.getNom());
		    	u.setPrenoms(p.getPrenoms());
		    	u.setTelephone(p.getTelephone());
		    	u.setUsername(p.getTelephone());
		    	u.setPassword( passwordEncoder.encode(p.getNom()+p.getTelephone()));
		    	u.setRoles("PARENT");
		    	u.setPermissions("ACCESS_PARENT");
		    	u.setIsparent(1);
		    User uparent=	userRepository.save(u);
		    if(uparent!=null) {
		    	Activation a = new Activation();
		    	String code =Utility.generateRandomDigits(4)+"" ;
		    	a.setCode(code);
		    	a.setIduser((int)uparent.getId());
		    	a.setStatus(0);
		    	activationDao.save(a);
		    	SendSms.send(SendSms.apiKey, uparent.getTelephone(),code ,SendSms.sender, "");
		    	reponse=this.getReponse(Utility.SUCCESSFUL_CODE, "Enregistrement effectué", uparent);
		    }
		    	
		    }else {
		    	reponse=this.getReponse(Utility.USER_EXIST_CODE, "utilisateur existe déja", us);
		    }
		    return reponse;
	    }
	    @GetMapping("/confirm/{iduser}/{code}")
	    public Reponse getConfirm(@PathVariable int iduser,@PathVariable String code) {
	    	Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
	    	Activation a = activationDao.findActivationByIduserAndCode(iduser, code);
	    			System.out.println(a.toString());
	    	User us= new User();
	    	if(a!=null) {
	    		a.setStatus(1);
	    		activationDao.save(a);
	    		Optional<User> u = userRepository.findById((long)iduser);
	    		if(u.isPresent()) {
	    			us = u.get() ;
	    			us.setStatus(1);
	    			userRepository.save(us);
	    			 reponse =this.getReponse(Utility.SUCCESSFUL_CODE, "SUCCES", us);
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
	    @GetMapping("/ecoles")
	    public Reponse getEcoles() {
	    	Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
	    	List<Ecole>ec = ecoleservice.listEcole();
	    	List<EcoleDto> ecoles = new ArrayList<>();
	    	if(!ec.isEmpty()) {
				for( Ecole eg : ec) {
					EcoleDto ecoledto = new EcoleDto();
					ecoledto.setId_ecole(eg.getId_ecole());
					ecoledto.setNom(eg.getNom());
					ecoledto.setTelephone(eg.getTelephone());
					ecoledto.setVille(eg.getVille());
					ecoledto.setQuartier(eg.getQuartier());
					ecoledto.setAdresse(eg.getAdresse());
					ecoledto.setEmail(eg.getEmail());
					ecoledto.setStatus(eg.getStatus());
					ecoles.add(ecoledto);
				}
				reponse.setCode(Utility.SUCCESSFUL_CODE);
				reponse.setMessage("SUCCES");
				reponse.setDatas(ecoles);
				
			}
	    	return reponse;
	    }
	    @PostMapping("/addParent")
	    public Reponse saveParent(@RequestBody AddParent addParent  ) {
	    	 Eleve eleve = eleveDao.findByEcoleAndMatricule(ecoleservice.getEcoleById(addParent.getId_ecole()), addParent.getMatricule());
	    	 Annee annee= anneeDao.findById(addParent.getId_annee()).get();
	    	 AnneeDto anneeDto= new AnneeDto();
	    	 anneeDto.setDate_debut(annee.getDate_debut());
	    	 anneeDto.setDate_fin(annee.getDate_fin());
	    	 anneeDto.setId_annee(annee.getId_annee());
	    	 anneeDto.setLibelle(annee.getLibelle());
	    	 User u =userRepository.getOne((long)addParent.getId_user()) ;
	    	 List<Object> datas=new ArrayList<>();
	    	 Reponse reponse =this.getReponse(Utility.FAILLURE_CODE, "ECHEC", null);
	    	 Set<Eleve>eleves=new HashSet<Eleve>();
	    	 if(eleve!=null) {
	    		 Set<MatiereDto> mats=new HashSet();
	    		 Parent parent = parentDao.findByNomAndTelephoneAndStatut(u.getNom(), u.getTelephone(), 1);
	    		 EleveDto eldto= new EleveDto();
	    		 eldto.setId_eleve(eleve.getId_eleve());
	    		 eldto.setNom(eleve.getNom());
	    		 eldto.setPrenoms(eleve.getPrenoms());
	    		 eldto.setMatricule(eleve.getMatricule());
	    		 eldto.setDatenaiss(eleve.getDatenaiss());
	    		 eldto.setSexe(eleve.getSexe());
	    		 if(parent!=null) {
	    			 eleves = parent.getEleves();
	    		 }
	    		 else{
	    		 parent= new Parent();
	    		 parent.setNom(u.getNom());
	    		 parent.setPrenoms(u.getPrenoms());
	    		 parent.setTelephone(u.getTelephone());
	    		 parent.setStatut(1);
	    		 
	    		 }
	    		 eleves.add(eleve);
	    		 parent.setEleves(eleves);
	    		 for(Eleve e :eleves) {
	    			 System.out.println(e.getMatricule());
	    		 }
	    		Parent p = parentDao.save(parent);
	    		if(p!=null) {
	    			u.setIsparent(p.getId_parent().intValue());
	    			userRepository.save(u);
	    		}
	    		 EleveClasseAnnee elca = eleveClasseAnneeDao.findByEleveAndAndAnneeAndStatut(eleve, annee, 1);
	    		 Classe cl= elca.getClasse();
	    		 ClasseDto cldto= new ClasseDto();
	    		 if(cl!=null) {
	    			 cldto.setId_classe(cl.getId_classe());
	    			 cldto.setCode(cl.getCode());
	    			 cldto.setLibelle(cl.getLibelle());
	    			 cldto.setStatus(cl.getStatus());
	    			 cldto.setCycle(cl.getCycle().getId_cycle());
	    			 Set<Matiere> matieres = cl.getMatieres(); 
	    			 for(Matiere m:matieres) {
	    				 MatiereDto mdto = new MatiereDto();
	    				 mdto.setCode(m.getCode());
	    				 mdto.setId_matiere(m.getId_matiere());
	    				 mdto.setLibelle(m.getLibelle());
	    				 mdto.setDescription(m.getDescription());
	    				 mdto.setStatus(m.getStatus());
	    				 mats.add(mdto);
	    			 }
	    		 }
	    		datas.add(eldto);
	    		datas.add(cldto);
	    		datas.add(mats);
	    		datas.add(anneeDto);
	    		reponse.setCode(Utility.SUCCESSFUL_CODE);
				reponse.setMessage("SUCCES");
				reponse.setDatas(datas);
	    	 }
	    	 return reponse;
	    }
	   /* @PostMapping("/souscription")
	    public Reponse souscrire(@RequestBody )*/
}
