package com.barbers.users.services;

import java.util.ArrayList;

import com.barbers.users.entities.Utilisateur;
import com.barbers.users.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	UtilisateurRepo utilisateurRepo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur user = utilisateurRepo.findByUsername(username);
		
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

}
