package com.uadb.vaccination.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UtilisateurSearchDTO {
    private String email;
    private String telephone;

    private int currentPage;
    private int pageSize;
    private int totalPages;
    private List<UtilisateurDTO> utilisateurDTOS;
}
