package com.uadb.vaccination.dtos;

import com.uadb.vaccination.entities.Coordonnes;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class CentreVaccinationDTO {
    private Long id;
    private String nom;
    private String adresse;
    private LocalTime heurreOuverture;
    private LocalTime heurreFermeture;
    private CoordonneDTO coordonneDTO;
    private List<UtilisateurDTO> utilisateurDTOList;
}
