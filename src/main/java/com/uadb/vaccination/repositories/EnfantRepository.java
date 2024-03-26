package com.uadb.vaccination.repositories;

import com.uadb.vaccination.entities.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfantRepository extends JpaRepository<Enfant,Long> {
}
