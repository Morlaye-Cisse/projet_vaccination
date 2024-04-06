package com.uadb.vaccination.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vaccin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nomVaccin;
    private String numeroLot;
    //definir un colonne de type texte
    @Column(name = "maladie_cible",columnDefinition = "TEXT")
    private String maladieCible;
    @Column(name = "effet_secondaire",columnDefinition = "TEXT")
    private String effetSecondaire;
}
