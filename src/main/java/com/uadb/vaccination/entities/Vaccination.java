package com.uadb.vaccination.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "enfant_id")
    private Enfant enfant;
    @ManyToOne
    @JoinColumn(name = "vaccin_id")
    private Vaccin vaccin;

    private LocalDateTime heureDate;
    private int nombreDose;
    private String voie_administration;
}
