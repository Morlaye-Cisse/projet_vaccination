package com.uadb.vaccination.webController;

import com.uadb.vaccination.dtos.ParentDTO;
import com.uadb.vaccination.exception.ParentNotFoundException;
import com.uadb.vaccination.services.parentServices.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/parent")
public class ParentRestController {
    private ParentService parentService;

    //recuperation de tous les users
    @GetMapping("/parents")
    public List<ParentDTO> getAllParentsDTO()
    {
        return parentService.getAllParentsDTO();
    }

    //recuperation du parent en fonction de l'id
    @GetMapping("/parents/{id}")
    public ParentDTO getParentDTO(@PathVariable(name = "id") Long parentId) throws ParentNotFoundException {
        return parentService.getParentDTO(parentId);
    }

    //Enregistrement d'un parent
    @PostMapping("/parents/{userEmail}")
    public ParentDTO saveParentDTO(@RequestBody ParentDTO parentDTO,@PathVariable(name = "userEmail")  String userEmail) throws ParentNotFoundException
    {
        return parentService.saveParent(parentDTO,userEmail);
    }

    @PutMapping("/parents/{id}")
    public ParentDTO updateParentDTO(@PathVariable(name = "id") Long parenId,@RequestBody ParentDTO parentDTO)
    {
        parentDTO.setId(parenId);
        return parentService.updateParentDTO(parentDTO);
    }

    @DeleteMapping("/parents/{id}")
    public void deleteParent(@PathVariable(name = "id") Long parentId)
    {
        parentService.deleteParentDTO(parentId);
    }
    @GetMapping("/parents/search")
    public List<ParentDTO> getParentSearch(@RequestParam(name = "telephone", defaultValue = "") String telephone)
    {
        return parentService.getParentSearch(telephone);
    }
}
