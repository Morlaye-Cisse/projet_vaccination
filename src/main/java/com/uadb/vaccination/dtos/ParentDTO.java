package com.uadb.vaccination.dtos;


import com.uadb.vaccination.entities.ENUM.LienParental;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ParentDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adress;
    private String lienParental;
    private Date dateInscription;
    private CentreVaccinationDTO centreVaccinationDTO;
}
