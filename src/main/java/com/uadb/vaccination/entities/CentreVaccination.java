package com.uadb.vaccination.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CentreVaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private LocalTime heurreOuverture;
    private LocalTime heurreFermeture;
    //coordonnes d'un centre de vaccination
    @ManyToOne
    @JoinColumn(name = "coordonnes_id")
    private Coordonnes coordonnes;

    //liste des parents
    // LAZY (par defaut) charge que les donnees de cette entite compte mes pas les operations
    // EAGER charge  les donnees de cette entite compte et les donnees des entite operations
    //un centre pour plusieur parents
    @OneToMany(mappedBy = "centreVaccination",fetch = FetchType.EAGER)
    List<Parent> parents;

    @OneToMany(mappedBy = "centreVaccination",fetch = FetchType.EAGER)
    List<Utilisateur> utilisateurList;
}
