package com.uadb.vaccination.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ParentSearchDTO {
    private String email;
    private String telephone;//rechercher par numero de telephone

    private int currentPage;//premier page
    private int pageSize;//taille du page afficher
    private int totalPages;
    private List<ParentDTO> parentDTOS;
}
