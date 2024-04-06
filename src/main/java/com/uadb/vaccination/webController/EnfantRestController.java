package com.uadb.vaccination.webController;

import com.uadb.vaccination.dtos.EnfantDTO;
import com.uadb.vaccination.dtos.ParentDTO;
import com.uadb.vaccination.exception.EnfantNotFoundException;
import com.uadb.vaccination.exception.ParentNotFoundException;
import com.uadb.vaccination.services.enfantService.EnfantService;
import com.uadb.vaccination.services.parentServices.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/enfant")
public class EnfantRestController {
    private EnfantService enfantService;

    //recuperation de tous les users
    @GetMapping("/enfants")
    public List<EnfantDTO> getAllEnfantDTO()
    {
        return enfantService.getAllEnfants();
    }

    //recuperation du parent en fonction de l'id
    @GetMapping("/enfants/{id}")
    public EnfantDTO getEnfantDTO(@PathVariable(name = "id") Long enfantId) throws EnfantNotFoundException {
        return enfantService.getEnfant(enfantId);
    }

    //Enregistrement d'un enfant
    @PostMapping("/enfants/{parentId}")
    public EnfantDTO saveEnfantDTO(
            @RequestBody EnfantDTO enfantDTO,
            @PathVariable(name = "parentId")  Long parentId) throws ParentNotFoundException {
        return enfantService.saveEnfant(enfantDTO,parentId);
    }

    @PutMapping("/enfants/{id}")
    public EnfantDTO updateEnfantDTO(@PathVariable(name = "id") Long enfantId,@RequestBody EnfantDTO enfantDTO) throws ParentNotFoundException {
        enfantDTO.setId(enfantId);
        return enfantService.updateEnfant(enfantDTO);
    }

    @DeleteMapping("/enfants/{id}")
    public void deleteEnfant(@PathVariable(name = "id") Long parentId)
    {
        enfantService.deleteEnfant(parentId);
    }
}
