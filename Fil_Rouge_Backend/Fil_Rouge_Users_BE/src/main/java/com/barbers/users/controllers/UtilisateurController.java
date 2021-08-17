package com.barbers.users.controllers;

import java.util.List;

import com.barbers.users.entities.Utilisateur;
import com.barbers.users.repositories.UtilisateurRepo;
import com.barbers.users.security.jwt.JwtUtil;
import com.barbers.users.security.models.AuthenticationRequest;
import com.barbers.users.security.models.AuthenticationResponse;
import com.barbers.users.services.MyUserDetailService;
import com.barbers.users.services.UtilisateurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/users")
public class UtilisateurController {

	@Autowired
	UtilisateurRepo utilisateurRepo;
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	UtilisateurServiceImp utilisateurServ;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
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

	@GetMapping("/username/{username}")
	public ResponseEntity<List<Utilisateur>> getUtilisateursByUsername(@PathVariable String username){
		List<Utilisateur> users = utilisateurServ.getUtilisateurByUsername(username);
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@GetMapping("/role/{role}")
	public ResponseEntity<List<Utilisateur>> getUtilisateursByRole(@PathVariable String role){
		List<Utilisateur> users = utilisateurServ.getUtilisateurByRole(role);
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@PostMapping("/add_utilisateur")
	public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur addeduser = utilisateurServ.addUtilisateur(utilisateur);
		return  new ResponseEntity<>(addeduser, HttpStatus.CREATED);

	}


	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try{
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		
		
		}catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur user = utilisateurServ.updateUtilisateur(id, utilisateur);
		return new ResponseEntity<>(user, HttpStatus.CREATED);

	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUtilisateur(@PathVariable long id) {
		utilisateurServ.deleteUtilisateur(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
}
