package com.uadb.vaccination.repositories;

import com.uadb.vaccination.entities.Parent;
import com.uadb.vaccination.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent,Long> {
    @Query("select p from Parent p where upper(p.telephone) like upper(concat('%', ?1, '%'))")
    List<Parent> findByTelephoneContainsIgnoreCase(String telephone);
}
