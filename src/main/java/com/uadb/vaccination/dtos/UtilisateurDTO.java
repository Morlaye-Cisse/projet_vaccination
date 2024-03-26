package com.uadb.vaccination.dtos;

import lombok.Data;

@Data
public class UtilisateurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String address;
    private CentreVaccinationDTO centreVaccinationDTO;
}
