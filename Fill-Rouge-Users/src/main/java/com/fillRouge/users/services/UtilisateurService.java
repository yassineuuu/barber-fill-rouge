package com.fillRouge.users.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.fillRouge.users.entities.Utilisateur;

public interface UtilisateurService {

	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur getUtilisateurById(long id);
	public Utilisateur getUtilisateurByUserId(String userId);
}
