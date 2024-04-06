package com.uadb.vaccination.services.vaccin;

import com.uadb.vaccination.dtos.VaccinDTO;
import com.uadb.vaccination.entities.Vaccin;
import com.uadb.vaccination.entities.Vaccination;
import com.uadb.vaccination.exception.VaccinNotFoundException;
import com.uadb.vaccination.mappers.VaccinMapper;
import com.uadb.vaccination.repositories.VaccinRepository;
import com.uadb.vaccination.repositories.VaccinationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VaccinServiceImplement implements VaccinService {

    private VaccinRepository vaccinRepository;
    private VaccinMapper vaccinMapper;
    @Override
    public List<VaccinDTO> getAllvaccinDTO() {
        List<Vaccin> vaccinList=vaccinRepository.findAll();

        return vaccinList.stream().map(
                vaccin -> vaccinMapper.fromVaccin(vaccin)
        ).toList();
    }

    @Override
    public VaccinDTO getVaccinDTO(Long vaccinId) throws VaccinNotFoundException {
        Vaccin vaccin=vaccinRepository.findById(vaccinId)
                .orElseThrow(() -> new VaccinNotFoundException("vaccin est introuvable"));
        return vaccinMapper.fromVaccin(vaccin);
    }

    @Override
    public VaccinDTO saveVaccinDTO(VaccinDTO vaccinDTO) {
        Vaccin saveVaccin=vaccinRepository.save(vaccinMapper.fromVaccinDTO(vaccinDTO));
        return vaccinMapper.fromVaccin(saveVaccin);
    }

    @Override
    public VaccinDTO updateVaccinDTO(VaccinDTO vaccinDTO) {
        Vaccin saveVaccin=vaccinRepository.save(vaccinMapper.fromVaccinDTO(vaccinDTO));
        return vaccinMapper.fromVaccin(saveVaccin);
    }

    @Override
    public void deleteVaccinDTO(Long vaccinId) {
        vaccinRepository.deleteById(vaccinId);
    }
}
