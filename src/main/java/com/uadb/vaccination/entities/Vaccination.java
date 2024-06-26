package com.uadb.vaccination.entities;


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
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombreDoses;
    private Boolean effectuer;
    private LocalDate datePrevue;
    private LocalDate dateEffectuer;
    @ManyToOne
    @JoinColumn(name = "enfant_id")
    private Enfant enfant;
    @ManyToOne
    @JoinColumn(name = "vaccin_id")
    private Vaccin vaccin;
}
