package com.uadb.vaccination.dtos;

import lombok.Data;

@Data
public class StatistiqueVaccinationDTO {

    //Le nombre d’enfants vaccinés en fonction du genre, du mois ou de l’année.
    private Long nombreFilleVaccineMois;
    private Long nombreGarconVaccineMois;

    private Long nombreFilleVaccineAnnees;
    private Long nombreGarconVaccineAnnees;

    private Long nombreEnfantVaccineMois;
    private Long nombreEnfantVaccineAnnees;


    //Le nombre d’enfant vaccinés en fonction du type de vaccin
    private Long nombreEnfantVaccineBCG;
    private Long nombreEnfantVaccinePolio0;
    private Long nombreEnfantVaccinePolio1;
    private Long nombreEnfantVaccinePolio2;
    private Long nombreEnfantVaccinePolio3;
    private Long nombreEnfantVaccinePenta1;
    private Long nombreEnfantVaccinePenta2;
    private Long nombreEnfantVaccinePenta3;
    private Long nombreEnfantVaccineVitamineA;
    private Long nombreEnfantVaccineVAR;
    private Long nombreEnfantVaccineVAA;

    //Le nombre d’enfants qui ont raté leur vaccin
    private Long nombreEnfantRaterVaccinations;

    //Le nombre d’enfants assidus
    private Long nombreEnfantAssidusVaccinations;

}
