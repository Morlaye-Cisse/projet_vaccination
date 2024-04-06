package com.uadb.vaccination.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class VaccinDTO {
    private Long id;
    private String nomVaccin;
    private String numeroLot;
    private String maladieCible;
    private String effetSecondaire;
}
