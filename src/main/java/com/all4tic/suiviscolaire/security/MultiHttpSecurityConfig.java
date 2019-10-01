package com.all4tic.suiviscolaire.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class MultiHttpSecurityConfig {
	@Autowired
	private UserPrincipalDetailsService userPrincipalDetailsService ;
	
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
		 		
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
		return daoAuthenticationProvider;
	}
	 @Configuration
	    @Order(1)                                                        
	    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
	        protected void configure(HttpSecurity http) throws Exception {
	           
	        	http
	        	//authorizeRequests().antMatchers("/*").permitAll();
	        	
	        		.csrf().disable()
	    			.httpBasic()
	    			.and()
	    			.authorizeRequests()
	    			.antMatchers("/auth/**").permitAll()
	    			.antMatchers("/api/**")
	    			.hasRole("ENSEIGNANT");
	    			//.and().addFilterBefore(new WebSecurityCorsFilter(), ChannelProcessingFilter.class);
	        	/* http
	             .authorizeRequests()
	                 .anyRequest().permitAll()
	                 .and()
	             .httpBasic();*/
	        	http.cors();
	        }
	    }

	    @Configuration                                                   
	    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	        	http
				.csrf().disable()
				.authorizeRequests()
				//.antMatchers("/*").permitAll()
				.antMatchers("/*").authenticated()
				.antMatchers("/classe","/classe/*", "/ecole","/ecole/*","/eleves","/eleve/*","/enseignant","/enseignant/*","/matiere","/matiere/*").hasAnyRole("ADMIN","USER")	
				.and()
				.formLogin()
				.failureUrl("/login.html?error=true")
				.loginPage("/login").permitAll()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
				.and()
				.rememberMe().tokenValiditySeconds(259200000).key("secret00!");
	        }
	    }
}
