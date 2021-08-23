package com.barbers.users.services;

import com.barbers.users.entities.Utilisateur;
import com.barbers.users.repositories.UtilisateurRepo;
import com.barbers.users.services.exceptions.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UtilisateurServiceImpTest {

    @Mock
    private UtilisateurRepo utilisateurRepo;
    private UtilisateurServiceImp utilisateurService;


    @BeforeEach
    void setUp() {
        utilisateurService = new UtilisateurServiceImp(utilisateurRepo);
    }


    @Test
    void canGetAllUtilisateurs() {
        //When
        utilisateurService.getAllUtilisateurs();

        //Then
        verify(utilisateurRepo).findAll();
    }

    @Test
    void canGetUtilisateurById() {

        //Given
        long id = 1;

        //When
        utilisateurService.getUtilisateurById(id);

        //Then
        verify(utilisateurRepo).findById(id);

    }

    @Test
    void canGetUtilisateurByUserId() {

        //Given
        String id = "1234AZERT";

        //When
        utilisateurService.getUtilisateurByUserId(id);

        //Then
        verify(utilisateurRepo).findByUserId(id);
    }

    @Test
    void canGetUtilisateurByUsername() {

        //Given
        String username = "1234AZERT";

        //When
        utilisateurService.getUtilisateurByUsername(username);

        //Then
        verify(utilisateurRepo).findByUsername(username);
    }

    @Test
    void canGetUtilisateurByRole() {

        //Given
        String role = "Client";

        //When
        utilisateurService.getUtilisateurByRole(role);

        //Then
        verify(utilisateurRepo).findByRole(role);
    }

    @Test
    void canAddUtilisateur() {
        //Given
        Utilisateur user = new Utilisateur(
                "12345AZERT",
                "Client",
                "Client@gmail.com",
                "12345678",
                "Client");

        //When
        utilisateurService.addUtilisateur(user);

        //Then
        ArgumentCaptor<Utilisateur> utilisateurArgumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        verify(utilisateurRepo).save(utilisateurArgumentCaptor.capture());

        Utilisateur capturedUtilisateur = utilisateurArgumentCaptor.getValue();
        assertThat(capturedUtilisateur).isEqualTo(user);
    }


    @Test
    void WillThrowIfUsernameExist() {
        //Given
        Utilisateur user = new Utilisateur(
                "12345AZERT",
                "Client",
                "Client@gmail.com",
                "12345678",
                "Client");

        given(utilisateurRepo.checkUsername(user.getUsername())).willReturn(true);


        //When

        //Then
        assertThatThrownBy(() -> utilisateurService.addUtilisateur(user))
        .isInstanceOf(BadRequestException.class)
        .hasMessageContaining("Username "+ user.getUsername()+ " already exist!!")
        ;

    }

    @Test
    void WillThrowIfEmailExist() {
        //Given
        Utilisateur user = new Utilisateur(
                "12345AZERT",
                "Client",
                "Client@gmail.com",
                "12345678",
                "Client");

        given(utilisateurRepo.checkEmail(user.getEmail())).willReturn(true);

        //When

        //Then
        assertThatThrownBy(() -> utilisateurService.addUtilisateur(user))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email "+ user.getEmail()+ " already exist!!")
        ;

    }



    @Test
    void getUtilisateurByUsernameLike() {
        //Given
        String username = "Bar";

        //When
        utilisateurService.getUtilisateurByUsernameLike(username);

        //Then
        verify(utilisateurRepo).findByUsernameLike("%"+username+"%");


    }

    @Test
    void getUtilisateurByEmail() {
        //Given
        String email = "aaa@email.com";

        //When
        utilisateurService.getUtilisateurByEmail(email);

        //Then
        verify(utilisateurRepo).findByEmail(email);

    }

    @Test
    @Disabled
    void canUpdateUtilisateur() {

    }

    @Test
    void canDeleteUtilisateur() {



    }
}
