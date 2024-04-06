package com.uadb.vaccination.services.enfantService;

import com.uadb.vaccination.dtos.EnfantDTO;
import com.uadb.vaccination.exception.EnfantNotFoundException;
import com.uadb.vaccination.exception.ParentNotFoundException;

import java.util.List;

public interface EnfantService {
    List<EnfantDTO> getAllEnfants();
    EnfantDTO getEnfant(Long enfantId) throws EnfantNotFoundException;
    EnfantDTO saveEnfant(EnfantDTO enfantDTO,Long parentId) throws ParentNotFoundException;
    EnfantDTO updateEnfant(EnfantDTO enfantDTO) throws ParentNotFoundException;
    void deleteEnfant(Long enfantId);
}
