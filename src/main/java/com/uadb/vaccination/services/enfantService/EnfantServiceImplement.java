package com.uadb.vaccination.services.enfantService;

import com.uadb.vaccination.dtos.EnfantDTO;
import com.uadb.vaccination.dtos.ParentDTO;
import com.uadb.vaccination.entities.CentreVaccination;
import com.uadb.vaccination.entities.Enfant;
import com.uadb.vaccination.entities.Parent;
import com.uadb.vaccination.exception.CentreNotFoundException;
import com.uadb.vaccination.exception.EnfantNotFoundException;
import com.uadb.vaccination.exception.ParentNotFoundException;
import com.uadb.vaccination.mappers.CentreVaccinationMapper;
import com.uadb.vaccination.mappers.EnfantMapper;
import com.uadb.vaccination.mappers.ParentMapper;
import com.uadb.vaccination.repositories.CentreVaccinationRepository;
import com.uadb.vaccination.repositories.EnfantRepository;
import com.uadb.vaccination.repositories.ParentRepository;
import com.uadb.vaccination.services.parentServices.ParentServiceImplement;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EnfantServiceImplement implements EnfantService{
    private ParentRepository parentRepository;
    private ParentMapper parentMapper;
    private EnfantMapper enfantMapper;
    private EnfantRepository enfantRepository;
    private ParentServiceImplement parentServiceImplement;
    private CentreVaccinationRepository centreVaccinationRepository;
    private CentreVaccinationMapper centreVaccinationMapper;

    @Override
    public List<EnfantDTO> getAllEnfants() {
        List<Enfant> enfantList=enfantRepository.findAll();

        return enfantList.stream().map(enfant->enfantMapper.fromEnfent(enfant))
                .toList();
    }

    @Override
    public EnfantDTO getEnfant(Long enfantId) throws EnfantNotFoundException {
        Enfant enfant=enfantRepository.findById(enfantId)
                .orElseThrow(() -> new EnfantNotFoundException("Enfant est introuvable"));

        return enfantMapper.fromEnfent(enfant);
    }

    @Override
    public EnfantDTO saveEnfant(EnfantDTO enfantDTO,Long parentId) throws ParentNotFoundException {

        Parent parent=parentRepository.findById(parentId)
                .orElseThrow(() -> new ParentNotFoundException("parent introuvable"));

        enfantDTO.setParentDTO(parentMapper.fromParent(parent));
        Enfant saveEnfant=enfantRepository.save(enfantMapper.fromEnfentDTO(enfantDTO));
        return enfantMapper.fromEnfent(saveEnfant);
    }

    @Override
    public EnfantDTO updateEnfant(EnfantDTO enfantDTO) {

        Enfant saveEnfant=enfantRepository.save(enfantMapper.fromEnfentDTO(enfantDTO));
        return enfantMapper.fromEnfent(saveEnfant);
    }

    @Override
    public void deleteEnfant(Long enfantId) {
        enfantRepository.deleteById(enfantId);
    }

}
