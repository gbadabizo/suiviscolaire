package com.all4tic.suiviscolaire.restcontrollers;

import java.security.Principal;
import java.util.Base64;
import java.util.Optional;

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
import com.all4tic.suiviscolaire.entities.Activation;
import com.all4tic.suiviscolaire.security.User;
import com.all4tic.suiviscolaire.security.UserPrincipalDetailsService;
import com.all4tic.suiviscolaire.security.UserRepository;
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
	
	 @GetMapping("/login")
	    public Principal login(Principal user) {
		 return user;      
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
}
