package com.barbers.users.repositories;

import com.barbers.users.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepo extends CrudRepository<Utilisateur, Long> {
    Utilisateur findById(long id);
    Utilisateur findByUserId(String userId);
    Utilisateur findByUsername(String username);
    List<Utilisateur> findByUsernameLike(String username);
    List<Utilisateur> findByRole(String role);
}
