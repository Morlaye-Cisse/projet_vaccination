package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.VaccinationDTO;
import com.uadb.vaccination.entities.Vaccination;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccinationMapper {
    public VaccinationDTO fromVaccination(Vaccination vaccination)
    {
        VaccinationDTO vaccinationDTO=new VaccinationDTO();
        BeanUtils.copyProperties(vaccination,vaccinationDTO);

        return vaccinationDTO;
    }

    public Vaccination fromVaccinationDTO(VaccinationDTO vaccinationDTO)
    {
        Vaccination vaccination=new Vaccination();
        BeanUtils.copyProperties(vaccinationDTO,vaccination);

        return vaccination;
    }
}
