package com.uadb.vaccination.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VaccinationDTO {
    private LocalDateTime heureDate;
    private int nombreDose;
    private String voie_administration;
}
