package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.CoordonneDTO;
import com.uadb.vaccination.dtos.EnfantDTO;
import com.uadb.vaccination.entities.Coordonnes;
import com.uadb.vaccination.entities.Enfant;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnfantMapper {
    private ParentMapper parentMapper;
    public EnfantDTO fromEnfent(Enfant enfant)
    {
        EnfantDTO enfantDTO=new EnfantDTO();
        BeanUtils.copyProperties(enfant,enfantDTO);
        enfantDTO.setParentDTO(parentMapper.fromParent(enfant.getParent()));

        return enfantDTO;
    }

    public Enfant fromEnfentDTO(EnfantDTO enfantDTO)
    {
        Enfant enfant=new Enfant();
        BeanUtils.copyProperties(enfantDTO,enfant);
        enfant.setParent(parentMapper.fromParentDTO(enfantDTO.getParentDTO()));

        return enfant;
    }
}
