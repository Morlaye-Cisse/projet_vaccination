package com.uadb.vaccination.services.vaccinations;

import com.uadb.vaccination.dtos.VaccinationDTO;
import com.uadb.vaccination.exception.EnfantNotFoundException;
import com.uadb.vaccination.exception.VaccinNotFoundException;
import com.uadb.vaccination.exception.VaccinationNotFoundException;

import java.util.List;

public interface VaccinationService {
    List<VaccinationDTO> getAllVaccinations();
    VaccinationDTO getVaccination(Long vaccinationId) throws VaccinationNotFoundException;
    VaccinationDTO saveVaccination(VaccinationDTO vaccinationDTO,Long enfantId,Long vaccinId) throws EnfantNotFoundException, VaccinNotFoundException;
    VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO);
    void deleteVaccination(Long vaccinationId);

    void validerVaccination(Long vaccinationId) throws VaccinationNotFoundException;
}
