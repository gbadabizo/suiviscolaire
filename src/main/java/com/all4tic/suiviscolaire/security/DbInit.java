package com.all4tic.suiviscolaire.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder ;
	public DbInit(UserRepository userRepository) {
	
		this.userRepository = userRepository;
	//	this.passwordEncoder= passwordEncoder ;
	}

	@Override
	public void run(String... args) throws Exception {
		//this.userRepository.deleteAll();
		User edem = new User("edem", passwordEncoder.encode("edem123"),"USER","");
		User admin = new User("admin", passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");	
		User enseignant = new User("koffi", passwordEncoder.encode("koffi123"),"ENSEIGNANT","ACCESS_TEST1");
		enseignant.setIsenseignant(6);
		User ens = new User("zao", passwordEncoder.encode("zao123"),"ENSEIGNANT","ACCESS_TEST1");	
		ens.setIsenseignant(7);
		List<User>users = Arrays.asList(enseignant,ens,edem,admin);
		for(User u : users) {
			System.out.println(u.getUsername()+" / "+u.getPassword());
		}
		
		//save to db
		//this.userRepository.saveAll(users);
	}
	

}
