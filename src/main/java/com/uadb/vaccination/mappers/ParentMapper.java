package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.ParentDTO;
import com.uadb.vaccination.entities.Parent;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParentMapper {
    private CentreVaccinationMapper centreVaccinationMapper;

    public ParentDTO fromParent(Parent parent)
    {
        ParentDTO parentDTO=new ParentDTO();

        BeanUtils.copyProperties(parent,parentDTO);

        parentDTO.setCentreVaccinationDTO(centreVaccinationMapper.fromCentreVaccination(parent.getCentreVaccination()));

        return parentDTO;
    }

    public Parent fromParentDTO(ParentDTO parentDTO)
    {
        Parent parent=new Parent();
        BeanUtils.copyProperties(parentDTO,parent);
        parent.setCentreVaccination(centreVaccinationMapper.fromCentreVaccinationDTO(parentDTO.getCentreVaccinationDTO()));

        return parent;
    }
}
