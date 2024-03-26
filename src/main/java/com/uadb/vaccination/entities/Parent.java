package com.uadb.vaccination.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true) //indique que ce colonne est unique
    private String telephone;
    private String adress;
    private String lienParental;
    private Date dateInscription;

    //plusieur parents pour un centre
    @ManyToOne
    private CentreVaccination centreVaccination;

    //un parent pour plusieur enfants
    @OneToMany(mappedBy ="parent",fetch = FetchType.EAGER)
    private List<Enfant> enfants;


//    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
//    private List<Enfant> children = new ArrayList<>();

}
