package com.uadb.vaccination.webController;

import com.uadb.vaccination.dtos.EnfantDTO;
import com.uadb.vaccination.dtos.VaccinDTO;
import com.uadb.vaccination.exception.EnfantNotFoundException;
import com.uadb.vaccination.exception.ParentNotFoundException;
import com.uadb.vaccination.exception.VaccinNotFoundException;
import com.uadb.vaccination.services.enfantService.EnfantService;
import com.uadb.vaccination.services.vaccin.VaccinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vaccin")
public class VaccinRestController {
    private VaccinService vaccinService;

    //recuperation de tous les users
    @GetMapping("/vaccins")
    public List<VaccinDTO> getAllVaccinDTO()
    {
        return vaccinService.getAllvaccinDTO();
    }

    //recuperation du parent en fonction de l'id
    @GetMapping("/vaccins/{id}")
    public VaccinDTO getVaccinDTO(@PathVariable(name = "id") Long vaccinId) throws VaccinNotFoundException {
        return vaccinService.getVaccinDTO(vaccinId);
    }

    //Enregistrement d'un enfant
    @PostMapping("/vaccins")
    public VaccinDTO saveVaccinDTO(@RequestBody VaccinDTO vaccinDTO) throws VaccinNotFoundException {
        return vaccinService.saveVaccinDTO(vaccinDTO);
    }

    @PutMapping("/vaccins/{id}")
    public VaccinDTO updateVaccinDTO(@PathVariable(name = "id") Long vaccinId,@RequestBody VaccinDTO vaccinDTO) {
        vaccinDTO.setId(vaccinId);
        return vaccinService.updateVaccinDTO(vaccinDTO);
    }

    @DeleteMapping("/vaccins/{id}")
    public void deleteVaccin(@PathVariable(name = "id") Long vaccinId)
    {
        vaccinService.deleteVaccinDTO(vaccinId);
    }
}
