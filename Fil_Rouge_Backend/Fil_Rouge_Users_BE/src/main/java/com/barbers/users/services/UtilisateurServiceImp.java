package com.barbers.users.services;

import com.barbers.users.entities.Utilisateur;
import com.barbers.users.repositories.UtilisateurRepo;
import com.barbers.users.services.exceptions.BadRequestException;
import com.barbers.users.shared.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@AllArgsConstructor
@Service
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

    @Override
    public Utilisateur getUtilisateurByUsername(String username) {
        Utilisateur users = utilisateurRepo.findByUsername(username);
        return users;
    }

    @Override
    public List<Utilisateur> getUtilisateurByUsernameLike(String username) {
        List<Utilisateur> users = (List<Utilisateur>) utilisateurRepo.findByUsernameLike("%"+username+"%");
        return users;
    }

    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        Utilisateur user = utilisateurRepo.findByEmail(email);
        return user;
    }

    @Override
    public List<Utilisateur> getUtilisateurByRole(String role) {
        List<Utilisateur> users = (List<Utilisateur>) utilisateurRepo.findByRole(role);
        return users;
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        String username = utilisateur.getUsername();
        String email = utilisateur.getEmail();

        boolean checkIfUsernameExist = utilisateurRepo.checkUsername(username);
        boolean checkIfEmailExist = utilisateurRepo.checkEmail(email);


        if (checkIfUsernameExist)
            throw new BadRequestException("Username "+ username+ " already exist!!");

        if (checkIfEmailExist)
            throw new BadRequestException("Email "+ email+ " already exist!!");


        utilisateur.setUserId(Utils.generateUserId(32));
        utilisateurRepo.save(utilisateur);
        return utilisateur;
    }

    @Override
    public Utilisateur updateUtilisateur(long id, Utilisateur utilisateur) {
        Utilisateur user = getUtilisateurById(id);

        user.setUsername(utilisateur.getUsername());
        user.setEmail(utilisateur.getEmail());
        user.setPassword(utilisateur.getPassword());
        user.setRole(utilisateur.getRole());

        utilisateurRepo.save(user);
        return user;
    }

    @Override
    public void deleteUtilisateur(long id) {

        Utilisateur user = getUtilisateurById(id);

        if (user == null)
            throw new BadRequestException("Utilisateur with id " + id + " does not exist");

        utilisateurRepo.deleteById(id);

    }

}
