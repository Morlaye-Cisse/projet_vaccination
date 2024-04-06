package com.uadb.vaccination.webController;

import com.uadb.vaccination.dtos.RvDTO;
import com.uadb.vaccination.exception.ParentNotFoundException;
import com.uadb.vaccination.exception.RvNotFoundException;
import com.uadb.vaccination.services.RendezVous.RendezVousService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/rv")
public class RvRestController {
    private RendezVousService rvService;

    @GetMapping("/rvs/{emailUser}")
    public List<RvDTO> getAllRv(@PathVariable(name = "emailUser") String emailUser) throws RvNotFoundException {
        return rvService.getAllRv(emailUser);
    }

    @GetMapping("/rvs/{emailUser}/{idRv}")
    public RvDTO getRvDTO(@PathVariable(name = "idRv") Long rvId)
    {
        return rvService.getRvDTO(rvId);
    }

    @PostMapping("/rvs/{telephone}/{userId}")
    public ResponseEntity<RvDTO> saveRvDTO(@RequestBody RvDTO rvDTO,
                                          @PathVariable(name = "userId") Long userId,
                                          @PathVariable(name = "telephone") Long telephone) throws ParentNotFoundException
    {
        RvDTO rvDTO1 = rvService.saveRvDTO(rvDTO,userId,telephone);
        return new ResponseEntity<>(rvDTO1, HttpStatus.ACCEPTED);
    }

    @PutMapping("/rvs/{rvId}")
    public RvDTO updateRvDTO(@RequestBody RvDTO rvDTO,@PathVariable(name = "rvId") Long rvId)
    {
        rvDTO.setId(rvId);
        return rvService.updateRvDTO(rvDTO);
    }

    @DeleteMapping("/rvs/{rvId}")
    public void deleteRvDTO(Long rvId)
    {
        rvService.deleteRvDTO(rvId);
    }

    @PostMapping("/rvs/confirmation/{rvId}")
    public void confirmationRv(@PathVariable(name = "rvId") Long rvId) throws ParentNotFoundException, RvNotFoundException
    {
        rvService.confirmationRv(rvId);
    }

    @PostMapping("/rvs/annulation/{rvId}")
    public void annulationRv(@PathVariable(name = "rvId") Long rvId) throws RvNotFoundException
    {
        rvService.annulationRv(rvId);
    }

    @PutMapping("/rvs/planifier/{rvId}")
    public void planifierRv(
            @PathVariable(name = "rvId") Long rvId,
            @RequestParam(name = "newDate",value = "0000-00-00") LocalDate newDate
    ) throws RvNotFoundException
    {
        rvService.planifierRv(rvId,newDate);
    }
}
