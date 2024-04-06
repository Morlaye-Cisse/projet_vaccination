package com.uadb.vaccination.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class EnfantDTO {
    private Long id;

    private String prenom;
    private String nom;
    private String dateNaissance;
    private String genre;
    private ParentDTO parentDTO;
}
