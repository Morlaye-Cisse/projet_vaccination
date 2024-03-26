package com.uadb.vaccination.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnfantDTO {
    private Long id;

    private String prenom;
    private String nom;
    private LocalDate dateNaissance;
    private String genre;
    private ParentDTO parentDTO;
}
