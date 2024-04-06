package com.uadb.vaccination.repositories;

import com.uadb.vaccination.dtos.CentreVaccinationDTO;
import com.uadb.vaccination.entities.CentreVaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CentreVaccinationRepository extends JpaRepository<CentreVaccination,Long> {
//    @Query("select c from CentreVaccination c where upper(c.adresse) like upper(concat('%', ?1, '%'))")
//    CentreVaccination findByAdresseContainsIgnoreCase(String adresse);
//@Query("select c from CentreVaccination c where upper(c.nom) = upper(?1) or upper(c.adresse) = upper(?2)")
//List<CentreVaccination> findByNomIgnoreCaseOrAdresseIgnoreCase(String nom, String adresse);
@Query("""
        select c from CentreVaccination c inner join c.utilisateurList utilisateurList
        where upper(utilisateurList.email) = upper(?1)""")
CentreVaccinationDTO findByUtilisateurList_EmailIgnoreCase(String email);

    @Query("""
            select c from CentreVaccination c inner join c.utilisateurList utilisateurList
            where upper(utilisateurList.email) = upper(?1)""")
    CentreVaccination findCentreVaccinationByUtilisateurList_EmailIgnoreCase(String email);
}
