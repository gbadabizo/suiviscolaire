package com.all4tic.suiviscolaire.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService{
	@Autowired
		private UserRepository userRepository ;
		
	public UserRepository getUserRepository() {
			return userRepository;
		}

		public void setUserRepository(UserRepository userRepository) {
			this.userRepository = userRepository;
		}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		System.out.println(userPrincipal.toString());
		return userPrincipal;
	}

}
