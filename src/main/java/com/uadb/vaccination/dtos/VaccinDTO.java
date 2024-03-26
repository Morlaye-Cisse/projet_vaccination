package com.uadb.vaccination.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class VaccinDTO {
    private Long id;

    private String nom;
    private String numero_lot;
    private String maladie_cible;
    private String effet_secondaire;
}
