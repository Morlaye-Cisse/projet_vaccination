package com.uadb.vaccination.services.centreServices;

import com.uadb.vaccination.dtos.CentreVaccinationDTO;
import com.uadb.vaccination.dtos.CoordonneDTO;
import com.uadb.vaccination.exception.CentreNotFoundException;

import java.util.List;

public interface CentreService {
    List<CentreVaccinationDTO> getAllCentreVaccination();
    CentreVaccinationDTO getCentreVaccination(Long centreId) throws CentreNotFoundException;
    CentreVaccinationDTO saveCentreVaccination(CentreVaccinationDTO centreDTO,Long longitude, Long latitude);
    CentreVaccinationDTO updateCentreVaccination(CentreVaccinationDTO centreDTO,Long longitude, Long latitude);
    void deleteCentreVaccination(Long centreId);
    CoordonneDTO saveCoordonne(Long longitude,Long latitude);
    void deleteCoordonne(Long coordId);

}
