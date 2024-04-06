package com.uadb.vaccination.services.vaccin;

import com.uadb.vaccination.dtos.VaccinDTO;
import com.uadb.vaccination.exception.VaccinNotFoundException;


import java.util.List;

public interface VaccinService {
    List<VaccinDTO> getAllvaccinDTO();
    VaccinDTO getVaccinDTO(Long vaccinId) throws VaccinNotFoundException;
    VaccinDTO saveVaccinDTO(VaccinDTO vaccinDTO);
    VaccinDTO updateVaccinDTO(VaccinDTO vaccinDTO);
    void deleteVaccinDTO(Long vaccinId);
}
