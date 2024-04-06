package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.VaccinationDTO;
import com.uadb.vaccination.entities.Vaccination;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccinationMapper {
    private EnfantMapper enfantMapper;
    private VaccinMapper vaccinMapper;

    public VaccinationDTO fromVaccination(Vaccination vaccination)
    {
        VaccinationDTO vaccinationDTO=new VaccinationDTO();
        BeanUtils.copyProperties(vaccination,vaccinationDTO);

        vaccinationDTO.setEnfantDTO(enfantMapper.fromEnfent(vaccination.getEnfant()));
        vaccinationDTO.setVaccinDTO(vaccinMapper.fromVaccin(vaccination.getVaccin()));

        return vaccinationDTO;
    }

    public Vaccination fromVaccinationDTO(VaccinationDTO vaccinationDTO)
    {
        Vaccination vaccination=new Vaccination();
        BeanUtils.copyProperties(vaccinationDTO,vaccination);

        vaccination.setEnfant(enfantMapper.fromEnfentDTO(vaccinationDTO.getEnfantDTO()));
        vaccination.setVaccin(vaccinMapper.fromVaccinDTO(vaccinationDTO.getVaccinDTO()));

        return vaccination;
    }
}
