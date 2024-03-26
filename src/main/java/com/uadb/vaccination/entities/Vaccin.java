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

    private String nom;
    private String numero_lot;
    //definir un colonne de type texte
    @Column(name = "maladie_cible",columnDefinition = "TEXT")
    private String maladie_cible;
    @Column(name = "effet_secondaire",columnDefinition = "TEXT")
    private String effet_secondaire;

}
