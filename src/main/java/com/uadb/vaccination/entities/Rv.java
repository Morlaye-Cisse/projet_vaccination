package com.uadb.vaccination.entities;


import com.uadb.vaccination.entities.ENUM.EtatRv;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //date est heure de rendez-vous
    private LocalDate dateRv;
    private LocalTime heureRv;
    private EtatRv etatRv;

    //identifiant etrangere du Parent
//    @ManyToOne
//    @JoinColumn(name = "parent_id")
//    private Parent parent;


    //identifiant etrangere de l'utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "parent_id")
    private Parent parent;

}
