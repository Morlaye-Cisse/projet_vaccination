package com.uadb.vaccination.repositories;

import com.uadb.vaccination.entities.Rv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RvRepository extends JpaRepository<Rv,Long> {
}
