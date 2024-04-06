package com.uadb.vaccination.dtos;

import com.uadb.vaccination.entities.ENUM.EtatRv;
import com.uadb.vaccination.entities.Parent;
import com.uadb.vaccination.entities.Utilisateur;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class RvDTO {
    private Long id;
    private LocalDate dateRv;
    private LocalTime heureRv;
    private EtatRv etatRv;
    private UtilisateurDTO utilisateurDTO;
    private ParentDTO parentDTO;
}
