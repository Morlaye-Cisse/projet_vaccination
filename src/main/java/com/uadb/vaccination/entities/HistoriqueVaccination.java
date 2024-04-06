package com.uadb.vaccination.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoriqueVaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate dateVaccination;
    private String lotVaccin;
    private String lieuVaccination;
    private String nomPersonel;
    private String reactionPosteVaccinale;


    @ManyToOne
    @JoinColumn(name = "enfant_id")
    private Enfant enfant;

    @ManyToOne
    @JoinColumn(name = "vaccin_id")
    private Vaccin vaccin;
}
