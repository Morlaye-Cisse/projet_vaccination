package com.uadb.vaccination.repositories;

import com.uadb.vaccination.entities.Parent;
import com.uadb.vaccination.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent,Long> {
//    @Query("select p from Parent p where upper(p.telephone) like upper(concat('%', ?1, '%'))")
//    List<Parent> findByTelephoneContainsIgnoreCase(Long telephone);

    @Query("select p from Parent p where p.telephone = ?1")
    Parent findByTelephone(Long telephone);

//    @Query("select p from Parent p where upper(p.telephone) = upper(?1)")
//    Parent findByTelephoneIgnoreCase(Long telephone);
//
//    @Query("select p from Parent p where upper(p.telephone) = upper(?1)")
//    Parent findParentByTelephoneIgnoreCase(@NonNull Long telephone);
}
