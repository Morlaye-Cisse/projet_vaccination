package com.uadb.vaccination.repositories;

import com.uadb.vaccination.entities.Coordonnes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordonnesRepository extends JpaRepository<Coordonnes,Long> {
}
