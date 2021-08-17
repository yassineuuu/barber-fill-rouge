package com.barbers.users;

import com.barbers.users.entities.Utilisateur;
import com.barbers.users.repositories.UtilisateurRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersApplicationTests {

    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Test
    void contextLoads() {
        Utilisateur user = new Utilisateur("12345AZERT", "NameTest", "aaaa@email.com", "1995", "Admin");
        utilisateurRepo.save(user);
        System.out.println(user.toString());
    }

}
