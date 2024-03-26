package com.uadb.vaccination.repositories;

import com.uadb.vaccination.entities.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<Vaccination,Long> {
}
