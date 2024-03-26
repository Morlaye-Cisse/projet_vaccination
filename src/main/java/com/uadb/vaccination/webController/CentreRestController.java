package com.uadb.vaccination.webController;

import com.uadb.vaccination.dtos.CentreVaccinationDTO;
import com.uadb.vaccination.dtos.CoordonneDTO;
import com.uadb.vaccination.exception.CentreNotFoundException;
import com.uadb.vaccination.services.centreServices.CentreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/centreVaccination")
public class CentreRestController {

    CentreService centreService;
    @GetMapping("/centres")
    List<CentreVaccinationDTO> getAllCentreVaccination()
    {
        return centreService.getAllCentreVaccination();
    }

    @GetMapping("/centres/{centreId}")
    CentreVaccinationDTO getCentreVaccination(@PathVariable(name = "centreId") Long centreId) throws CentreNotFoundException
    {
        return centreService.getCentreVaccination(centreId);
    }

    @PostMapping("/centres")
    CentreVaccinationDTO saveCentreVaccination(@RequestBody CentreVaccinationDTO centreDTO,@RequestParam(name = "longitude") Long longitude,@RequestParam(name = "latitude") Long latitude)
    {
        return centreService.saveCentreVaccination(centreDTO,longitude,latitude);
    }
    @PutMapping("/centres/{centreId}")
    CentreVaccinationDTO updateCentreVaccination(
            @RequestBody CentreVaccinationDTO centreDTO,
            @RequestParam(name = "longitude") Long longitude,
            @RequestParam(name = "latitude")  Long latitude,
            @PathVariable(name = "centreId")  Long centreId)
    {
        centreDTO.setId(centreId);
        return centreService.updateCentreVaccination(centreDTO,longitude,latitude);
    }

    @DeleteMapping("/centres/{centreId}")
    void deleteCentreVaccination(Long centreId)
    {
        centreService.deleteCentreVaccination(centreId);
    }
}
