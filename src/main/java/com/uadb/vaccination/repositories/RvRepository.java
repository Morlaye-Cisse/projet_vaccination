package com.uadb.vaccination.repositories;

import com.uadb.vaccination.entities.ENUM.EtatRv;
import com.uadb.vaccination.entities.Parent;
import com.uadb.vaccination.entities.Rv;
import com.uadb.vaccination.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RvRepository extends JpaRepository<Rv,Long> {

    @Query("select r from Rv r where r.utilisateur.email = ?1 order by r.id DESC")
    List<Rv> findByUtilisateur_EmailOrderByIdDesc(String email);
}
