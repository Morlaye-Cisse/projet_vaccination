package com.uadb.vaccination.repositories;

import com.uadb.vaccination.dtos.UtilisateurDTO;
import com.uadb.vaccination.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Utilisateur,Long> {

    @Query("""
            select u from Utilisateur u
            where upper(u.email) like upper(concat('%', ?1, '%')) and upper(u.telephone) like upper(concat('%', ?2, '%'))""")
    List<Utilisateur> findByEmailContainsIgnoreCaseAndTelephoneContainsIgnoreCase(String email, Long telephone);

    @Query("select u from Utilisateur u where u.email = ?1")
    Utilisateur findByEmail(String email);

    @Query("select u from Utilisateur u where upper(u.email) like upper(concat('%', ?1, '%'))")
    UtilisateurDTO findByEmailContainsIgnoreCase(String email);

    @Query("select u from Utilisateur u where upper(u.email) = upper(?1)")
    Utilisateur findByEmailIgnoreCase(String email);
}
