package com.barbers.users.services;

import java.util.List;

import com.barbers.users.entities.Utilisateur;
import org.springframework.web.bind.annotation.PathVariable;


public interface UtilisateurService {

	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur getUtilisateurById(long id);
	public Utilisateur getUtilisateurByUserId(String userId);
}
