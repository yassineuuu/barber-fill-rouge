package com.barbers.users.repositories;

import com.barbers.users.entities.Utilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class UtilisateurRepoTest {

    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Test
    void itShouldFindUtilisateurById() {
        //Given
        long id = 1;
        Utilisateur user = new Utilisateur(id,
                                        "12345AZERT",
                                        "Client",
                                        "Client@gmail.com",
                                        "12345678",
                                        "Client");

        utilisateurRepo.save(user);

        //When
        Utilisateur expected = utilisateurRepo.findById(id);

        //Then

        assertEquals(expected,user);
    }

    @Test
    void itShouldFindUtilisateurByUserId() {
        //Given
        String userId = "1234567AZERT";
        Utilisateur user = new Utilisateur(
                userId,
                "Client1",
                "Client1@gmail.com",
                "12345678",
                "Client");

        utilisateurRepo.save(user);

        //When
        Utilisateur expected = utilisateurRepo.findByUserId(userId);

        //Then

        assertEquals(expected,user);
    }

    @Test
    void itShouldFindUtilisateurByUsername() {

        //Given
        String username = "username";
        Utilisateur user = new Utilisateur(
                "12345AZERT",
                username,
                "ClientU@gmail.com",
                "12345678",
                "Client");

        utilisateurRepo.save(user);

        //When
        Utilisateur expected = utilisateurRepo.findByUsername(username);

        //Then

        assertEquals(expected,user);

    }

    @Test
    void itShouldFindUtilisateurByUsernameLike() {
        //Given
        String username = "Bar";

        Utilisateur user1 = new Utilisateur(
                "12345AZERT",
                "Barber1",
                "Barber1@gmail.com",
                "12345678",
                "Barber");
        Utilisateur user2 = new Utilisateur(
                "123456AZERT",
                "Barber2",
                "Barber2@gmail.com",
                "12345678",
                "Barber");

        utilisateurRepo.save(user1);
        utilisateurRepo.save(user2);

        List<Utilisateur> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        //When
        List<Utilisateur> expected = utilisateurRepo.findByUsernameLike("%"+username+"%");

        //Then

        assertEquals(expected, users);
    }

    @Test
    void itShouldFindUtilisateurByRole() {
        //Given
        String role = "Admin";

        Utilisateur user1 = new Utilisateur(
                "12345AZERT",
                "role1",
                "Barber1@gmail.com",
                "12345678",
                role);
        Utilisateur user2 = new Utilisateur(
                "123456AZERT",
                "role2",
                "Barber2@gmail.com",
                "12345678",
                role);

        utilisateurRepo.save(user1);
        utilisateurRepo.save(user2);

        List<Utilisateur> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        //When
        List<Utilisateur> expected = utilisateurRepo.findByRole(role);

        //Then

        assertEquals(expected, users);
    }
}
