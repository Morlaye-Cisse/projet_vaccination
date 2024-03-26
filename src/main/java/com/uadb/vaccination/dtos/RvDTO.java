package com.uadb.vaccination.dtos;

import com.uadb.vaccination.entities.ENUM.EtatRv;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RvDTO {
    private Long id;
    private LocalDateTime dateHeure;
    private EtatRv etatRv;
}
