package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.CentreVaccinationDTO;
import com.uadb.vaccination.entities.CentreVaccination;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CentreVaccinationMapper {

    private CoordonneMapper coordonneMapper;

    public CentreVaccinationDTO fromCentreVaccination(CentreVaccination centreVaccination)
    {
        CentreVaccinationDTO centreVaccinationDTO=new CentreVaccinationDTO();

        BeanUtils.copyProperties(centreVaccination,centreVaccinationDTO);
        //copier l'entite coordonne de centreVac ver cenntreVac..DTO
        centreVaccinationDTO.setCoordonneDTO(coordonneMapper.fromCoordonne(centreVaccination.getCoordonnes()));

        return centreVaccinationDTO;
    }

    public CentreVaccination fromCentreVaccinationDTO(CentreVaccinationDTO centreVaccinationDTO)
    {
        CentreVaccination centreVaccination=new CentreVaccination();

        BeanUtils.copyProperties(centreVaccinationDTO,centreVaccination);

        //copier l'entite coordonneDTO de centreVac..DTO ver cenntreVac..
        centreVaccination.setCoordonnes(coordonneMapper.fromCoordonneDTO(centreVaccinationDTO.getCoordonneDTO()));

        return centreVaccination;
    }
}
