package com.uadb.vaccination.repositories;

import com.uadb.vaccination.entities.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinRepository extends JpaRepository<Vaccin,Long> {
}
