package com.fillRouge.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fillRouge.users.entities.Utilisateur;
import com.fillRouge.users.repository.UtilisateurRepo;
import com.fillRouge.users.services.UtilisateurServiceImp;

@RestController
@RequestMapping("api/users")
public class UtilisateurController {

	@Autowired
	UtilisateurRepo utilisateurRepo;
	
	@Autowired
	UtilisateurServiceImp utilisateurServ;
	
	@GetMapping()
	public ResponseEntity<List<Utilisateur>> getAllUtilisateurs(){
		List<Utilisateur> users = utilisateurServ.getAllUtilisateurs();
		return new ResponseEntity<>(users, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable long id) {
		Utilisateur user = utilisateurServ.getUtilisateurById(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	@GetMapping("/userId/{userId}")
	public ResponseEntity<Utilisateur> getUtilisateurByUserId(@PathVariable String userId) {
		
		Utilisateur user = utilisateurServ.getUtilisateurByUserId(userId);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
}
