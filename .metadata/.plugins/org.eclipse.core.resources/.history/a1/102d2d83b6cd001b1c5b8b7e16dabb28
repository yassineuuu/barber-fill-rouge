package com.fillRouge.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fillRouge.users.entities.Utilisateur;


@Repository
public interface UtilisateurRepo extends CrudRepository<Utilisateur, Long> {

	Utilisateur findById(long id);
	Utilisateur findByUserId(String userId);
	
}
