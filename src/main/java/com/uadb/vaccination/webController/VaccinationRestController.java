package com.uadb.vaccination.webController;

import com.uadb.vaccination.dtos.VaccinDTO;
import com.uadb.vaccination.dtos.VaccinationDTO;
import com.uadb.vaccination.exception.EnfantNotFoundException;
import com.uadb.vaccination.exception.VaccinNotFoundException;
import com.uadb.vaccination.exception.VaccinationNotFoundException;
import com.uadb.vaccination.services.vaccin.VaccinService;
import com.uadb.vaccination.services.vaccinations.VaccinationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vaccination")
public class VaccinationRestController {
    private VaccinationService vaccinationService;

    //recuperation de tous les users
    @GetMapping("/vaccinations")
    public List<VaccinationDTO> getAllVaccinationDTO()
    {
        return vaccinationService.getAllVaccinations();
    }

    //recuperation du parent en fonction de l'id
    @GetMapping("/vaccinations/{id}")
    public VaccinationDTO getVaccinationDTO(@PathVariable(name = "id") Long vaccinationId) throws VaccinationNotFoundException {
        return vaccinationService.getVaccination(vaccinationId);
    }

    //Enregistrement d'un enfant
    @PostMapping("/vaccinations/{enfantId}/{vaccinId}")
    public VaccinationDTO saveVaccinationDTO(
            @RequestBody VaccinationDTO vaccinationDTO,
            @PathVariable(name = "enfantId") Long enfantId,
            @PathVariable(name = "vaccinId") Long vaccinId) throws EnfantNotFoundException, VaccinNotFoundException {
        return vaccinationService.saveVaccination(vaccinationDTO,enfantId,vaccinId);
    }

    @PutMapping("/vaccinations/{vaccinationId}")
    public VaccinationDTO updateVaccinationDTO(
            @PathVariable(name = "vaccinationId") Long vaccinationId,
            @RequestBody VaccinationDTO vaccinationDTO) {
        vaccinationDTO.setId(vaccinationId);
        return vaccinationService.updateVaccination(vaccinationDTO);
    }

    @DeleteMapping("/vaccinations/{id}")
    public ResponseEntity<String> deleteVaccination(@PathVariable(name = "id") Long vaccinationId)
    {
        vaccinationService.deleteVaccination(vaccinationId);
        return new ResponseEntity<>("vaccination supprimer avec suucces", HttpStatus.ACCEPTED);
    }

    @PostMapping("/vaccinations/valider/{vaccinationId}")
    public ResponseEntity<String> validerVaccination(@PathVariable(name = "vaccinationId") Long vaccinationId) throws VaccinationNotFoundException
    {
        vaccinationService.validerVaccination(vaccinationId);

        return new ResponseEntity<>("vaccination valider avec suucces", HttpStatus.ACCEPTED);
    }
}
