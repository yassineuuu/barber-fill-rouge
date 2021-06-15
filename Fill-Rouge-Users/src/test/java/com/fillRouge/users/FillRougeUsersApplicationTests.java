package com.fillRouge.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fillRouge.users.entities.Utilisateur;
import com.fillRouge.users.repository.UtilisateurRepo;
import com.fillRouge.users.shared.Utils;

@SpringBootTest
class FillRougeUsersApplicationTests {
	
	@Autowired
	UtilisateurRepo utilisateurRepo;
	
	@Autowired
	Utils utils;

	@Test
	void contextLoads() {
		
		Utilisateur user = new Utilisateur(utils.generateUserId(32), "Barber1", "Barber1@email.com","1234", "Barber");
		
		utilisateurRepo.save(user);
		
		System.out.println("Done");
		
		
	}

}
