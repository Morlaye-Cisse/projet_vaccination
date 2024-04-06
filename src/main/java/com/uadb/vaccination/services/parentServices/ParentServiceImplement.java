package com.uadb.vaccination.services.parentServices;

import com.uadb.vaccination.dtos.CentreVaccinationDTO;
import com.uadb.vaccination.dtos.ParentDTO;
import com.uadb.vaccination.entities.CentreVaccination;
import com.uadb.vaccination.entities.Parent;
import com.uadb.vaccination.exception.ParentNotFoundException;
import com.uadb.vaccination.exception.UserNotFoundException;
import com.uadb.vaccination.mappers.CentreVaccinationMapper;
import com.uadb.vaccination.mappers.ParentMapper;
import com.uadb.vaccination.repositories.CentreVaccinationRepository;
import com.uadb.vaccination.repositories.ParentRepository;
import com.uadb.vaccination.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ParentServiceImplement implements ParentService {
    private ParentMapper parentMapper;
    private CentreVaccinationMapper centreVaccinationMapper;
    private final ParentRepository parentRepository;
    private final CentreVaccinationRepository centreVaccinationRepository;
    private final UserRepository userRepository;

    @Override
    public ParentDTO saveParent(ParentDTO parentDTO, String userEmail) throws ParentNotFoundException {
        //email du user logged
        //id du centre grace a email du user logged
        //recuperation du centre grace a id centre
        CentreVaccination centre= centreVaccinationRepository.findCentreVaccinationByUtilisateurList_EmailIgnoreCase(userEmail);
        if(centre==null)
            throw new UserNotFoundException("centre de l'utilisateur introuvable");

        //verifier si l'utilisateur existe
        Parent parentTel= parentRepository.findByTelephone(parentDTO.getTelephone());
        if(parentTel != null)
            throw new UserNotFoundException("l'utilisateur existe dejat !");

        //conversion en centre...DTO
        CentreVaccinationDTO centreDTO= centreVaccinationMapper.fromCentreVaccination(centre);
        parentDTO.setCentreVaccinationDTO(centreDTO);

        //ajouter le parent dans la liste des parents du centre
//        centreDTO.getParentsDTO().add(parentDTO);

        //ajouter la date du systeme
        parentDTO.setDateInscription(new Date());

        //conversion du parentDTO en parent
        Parent parent=parentMapper.fromParentDTO(parentDTO);

        centre.getParents().add(parent);

        //enregistrement
        Parent saveParent=parentRepository.save(parent);

        return parentMapper.fromParent(saveParent);
    }

    @Override
    public List<ParentDTO> getAllParentsDTO() {
        List<Parent> parentList=parentRepository.findAll();

        return parentList.stream().map(parent -> parentMapper.fromParent(parent))
                .collect(Collectors.toList());
    }

    @Override
    public ParentDTO getParentDTO(Long parentId) throws ParentNotFoundException {
        Parent parent=parentRepository.findById(parentId)
                .orElseThrow(() -> new ParentNotFoundException("Parent introuvable"));
        return parentMapper.fromParent(parent);
    }

    @Override
    public ParentDTO updateParentDTO(ParentDTO parentDTO) {
        Parent parent=parentMapper.fromParentDTO(parentDTO);
        Parent saveParent=parentRepository.save(parent);

        return parentMapper.fromParent(saveParent);
    }

    @Override
    public void deleteParentDTO(Long parentId) {
        parentRepository.deleteById(parentId);
    }
}
