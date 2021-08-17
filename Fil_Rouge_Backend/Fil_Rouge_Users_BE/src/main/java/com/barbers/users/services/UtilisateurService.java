package com.barbers.users.services;

import java.util.List;

import com.barbers.users.entities.Utilisateur;



public interface UtilisateurService {

	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur getUtilisateurById(long id);
	public Utilisateur getUtilisateurByUserId(String userId);
	public List<Utilisateur> getUtilisateurByUsername(String username);
	public List<Utilisateur> getUtilisateurByRole(String role);
	public Utilisateur addUtilisateur(Utilisateur utilisateur);
	public Utilisateur updateUtilisateur(long id, Utilisateur utilisateur);
	void deleteUtilisateur(long id);
}
