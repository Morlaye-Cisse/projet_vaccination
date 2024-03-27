package com.uadb.vaccination.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Utilisateur
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    @Column(unique = true) //indique que ce colonne est unique
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "centre_vaccination_id")
    private CentreVaccination centreVaccination;
}
