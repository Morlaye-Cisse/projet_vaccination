package com.uadb.vaccination.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enfant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String prenom;
    private String nom;
    private String dateNaissance;
    private String genre;

    //plusieur enfant pour un parents
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

//    //plusieur enfant pour un parents
//    @ManyToOne
//    @JoinColumn(name = "parent_2")
//    private Parent parent2;

}
