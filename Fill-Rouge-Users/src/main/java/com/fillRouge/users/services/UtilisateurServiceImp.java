package com.fillRouge.users.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fillRouge.users.entities.Utilisateur;
import com.fillRouge.users.repository.UtilisateurRepo;


@Service
@Transactional
public class UtilisateurServiceImp implements UtilisateurService {
	
	@Autowired
	UtilisateurRepo utilisateurRepo;

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		List<Utilisateur> users = (List<Utilisateur>) utilisateurRepo.findAll();
		return users;
	}

	@Override
	public Utilisateur getUtilisateurById(long id) {
		Utilisateur user = utilisateurRepo.findById(id);
		return user;
	}

	@Override
	public Utilisateur getUtilisateurByUserId(String userId) {
		Utilisateur user = utilisateurRepo.findByUserId(userId);
		return user;
	}

}
