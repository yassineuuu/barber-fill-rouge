package com.barbers.users.repositories;

import com.barbers.users.entities.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepo extends CrudRepository<Utilisateur, Long> {
    Utilisateur findById(long id);
    Utilisateur findByUserId(String userId);
    Utilisateur findByUsername(String username);
    Utilisateur findByEmail(String email);
    List<Utilisateur> findByUsernameLike(String username);
    List<Utilisateur> findByRole(String role);

    @Query("select case when count(u) > 0 then true else false end from utilisateur u where u.username = ?1")
    boolean checkUsername(String username);

    @Query("select case when count(u) > 0 then true else false end from utilisateur u where u.email = ?1")
    boolean checkEmail(String email);

}
