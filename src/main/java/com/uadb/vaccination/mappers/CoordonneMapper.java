package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.CentreVaccinationDTO;
import com.uadb.vaccination.dtos.CoordonneDTO;
import com.uadb.vaccination.entities.CentreVaccination;
import com.uadb.vaccination.entities.Coordonnes;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CoordonneMapper {
    public CoordonneDTO fromCoordonne(Coordonnes coordonnes)
    {
        CoordonneDTO coordonneDTO=new CoordonneDTO();

        BeanUtils.copyProperties(coordonnes,coordonneDTO);

        return coordonneDTO;
    }

    public Coordonnes fromCoordonneDTO(CoordonneDTO coordonneDTO)
    {
        Coordonnes coordonnes=new Coordonnes();

        BeanUtils.copyProperties(coordonneDTO,coordonnes);

        return coordonnes;
    }
}
