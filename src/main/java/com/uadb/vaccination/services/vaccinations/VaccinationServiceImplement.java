package com.uadb.vaccination.services.vaccinations;

import com.uadb.vaccination.dtos.VaccinationDTO;
import com.uadb.vaccination.entities.Enfant;
import com.uadb.vaccination.entities.Vaccin;
import com.uadb.vaccination.entities.Vaccination;
import com.uadb.vaccination.exception.EnfantNotFoundException;
import com.uadb.vaccination.exception.VaccinNotFoundException;
import com.uadb.vaccination.exception.VaccinationNotFoundException;
import com.uadb.vaccination.mappers.EnfantMapper;
import com.uadb.vaccination.mappers.VaccinMapper;
import com.uadb.vaccination.mappers.VaccinationMapper;
import com.uadb.vaccination.repositories.EnfantRepository;
import com.uadb.vaccination.repositories.VaccinRepository;
import com.uadb.vaccination.repositories.VaccinationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VaccinationServiceImplement implements VaccinationService{
    private EnfantRepository enfantRepository;
    private VaccinRepository vaccinRepository;
    private VaccinationRepository vaccinationRepository;
    private EnfantMapper enfantMapper;
    private VaccinationMapper vaccinationMapper;
    private VaccinMapper vaccinMapper;

    @Override
    public List<VaccinationDTO> getAllVaccinations() {
        List<Vaccination> vaccinationDTOList=vaccinationRepository.findAll();

        return vaccinationDTOList.stream().map(
                vaccination -> vaccinationMapper.fromVaccination(vaccination)
        ).toList();
    }

    @Override
    public VaccinationDTO getVaccination(Long vaccinationId) throws VaccinationNotFoundException {
        Vaccination vaccination=vaccinationRepository.findById(vaccinationId)
                .orElseThrow(() -> new VaccinationNotFoundException("vaccination introuvable"));

        return vaccinationMapper.fromVaccination(vaccination);
    }

    @Override
    public VaccinationDTO saveVaccination(VaccinationDTO vaccinationDTO, Long enfantId, Long vaccinId) throws EnfantNotFoundException, VaccinNotFoundException {
        Enfant enfant=enfantRepository.findById(enfantId)
                .orElseThrow(() -> new EnfantNotFoundException("Enfant est introuvable"));
        Vaccin vaccin=vaccinRepository.findById(vaccinId)
                .orElseThrow(() -> new VaccinNotFoundException("vaccin est introuvable"));

        vaccinationDTO.setVaccinDTO(vaccinMapper.fromVaccin(vaccin));
        vaccinationDTO.setEnfantDTO(enfantMapper.fromEnfent(enfant));
        vaccinationDTO.setEffectuer(false);
        Vaccination vaccinationSave=vaccinationRepository.save(
                vaccinationMapper.fromVaccinationDTO(vaccinationDTO));

        return vaccinationMapper.fromVaccination(vaccinationSave);
    }

    @Override
    public VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO) {
        Vaccination vaccinationSave=vaccinationRepository.save(
                vaccinationMapper.fromVaccinationDTO(vaccinationDTO));

        return vaccinationMapper.fromVaccination(vaccinationSave);
    }

    @Override
    public void deleteVaccination(Long vaccinationId) {
        vaccinationRepository.deleteById(vaccinationId);
    }
    @Override
    public void validerVaccination(Long vaccinationId) throws VaccinationNotFoundException {
        Vaccination vaccination=vaccinationRepository.findById(vaccinationId)
                .orElseThrow(() -> new VaccinationNotFoundException("vaccination not found"));
        vaccination.setDateEffectuer(LocalDate.now());
        vaccination.setEffectuer(true);
    }
}
