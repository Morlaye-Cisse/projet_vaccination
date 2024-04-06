package com.uadb.vaccination.dtos;

import com.uadb.vaccination.entities.Enfant;
import com.uadb.vaccination.entities.Vaccin;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VaccinationDTO {
    private Long id;
    private String nombreDoses;
    private Boolean effectuer;
    private LocalDate datePrevue;
    private LocalDate DateEffectuer;
    private EnfantDTO enfantDTO;
    private VaccinDTO vaccinDTO;
}
