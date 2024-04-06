package com.uadb.vaccination.services.RendezVous;

import com.uadb.vaccination.dtos.RvDTO;
import com.uadb.vaccination.exception.ParentNotFoundException;
import com.uadb.vaccination.exception.RvNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface RendezVousService {
    List<RvDTO> getAllRv(String emailUser) throws RvNotFoundException;
    RvDTO getRvDTO(Long rvId);

    RvDTO saveRvDTO(RvDTO rvDTO, Long userId,Long telephone) throws ParentNotFoundException;

    RvDTO updateRvDTO(RvDTO rvDTO);
    void deleteRvDTO(Long rvId);
    void confirmationRv(Long rvId) throws ParentNotFoundException, RvNotFoundException;
    void annulationRv(Long rvId) throws RvNotFoundException;
    void planifierRv(Long rvId, LocalDate newDate) throws RvNotFoundException;
}
