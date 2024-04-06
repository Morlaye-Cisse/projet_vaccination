package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.VaccinDTO;
import com.uadb.vaccination.dtos.VaccinationDTO;
import com.uadb.vaccination.entities.Vaccin;
import com.uadb.vaccination.entities.Vaccination;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccinMapper {
    public VaccinDTO fromVaccin(Vaccin vaccin)
    {
        VaccinDTO vaccinDTO=new VaccinDTO();
        BeanUtils.copyProperties(vaccin,vaccinDTO);

        return vaccinDTO;
    }

    public Vaccin fromVaccinDTO(VaccinDTO vaccinDTO)
    {
        Vaccin vaccin=new Vaccin();
        BeanUtils.copyProperties(vaccinDTO,vaccin);

        return vaccin;
    }
}
