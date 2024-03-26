package com.uadb.vaccination.services.centreServices;

import com.uadb.vaccination.dtos.CentreVaccinationDTO;
import com.uadb.vaccination.dtos.CoordonneDTO;
import com.uadb.vaccination.entities.CentreVaccination;
import com.uadb.vaccination.entities.Coordonnes;
import com.uadb.vaccination.exception.CentreNotFoundException;
import com.uadb.vaccination.mappers.CentreVaccinationMapper;
import com.uadb.vaccination.mappers.CoordonneMapper;
import com.uadb.vaccination.repositories.CentreVaccinationRepository;
import com.uadb.vaccination.repositories.CoordonnesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CentreServiceImplement implements CentreService{
    CoordonneMapper coordonneMapper;
    CoordonnesRepository coordonnesRepository;
    CentreVaccinationMapper centreVaccinationMapper;
    private final CentreVaccinationRepository centreVaccinationRepository;

    @Override
    public List<CentreVaccinationDTO> getAllCentreVaccination() {
        List<CentreVaccination> centres= centreVaccinationRepository.findAll();

        return centres.stream().map(centre ->
                centreVaccinationMapper.fromCentreVaccination(centre)).collect(Collectors.toList());
    }

    @Override
    public CentreVaccinationDTO getCentreVaccination(Long centreId) throws CentreNotFoundException {
        CentreVaccination centreVaccination = centreVaccinationRepository.findById(centreId)
                .orElseThrow(() ->new CentreNotFoundException("Centre est introuvable"));

        return centreVaccinationMapper.fromCentreVaccination(centreVaccination);
    }


    @Override
    public CentreVaccinationDTO saveCentreVaccination(CentreVaccinationDTO centreDTO,Long longitude, Long latitude) {
        CoordonneDTO coordonneDTO=saveCoordonne(longitude,latitude);
        centreDTO.setCoordonneDTO(coordonneDTO);

        CentreVaccination centre=centreVaccinationMapper.fromCentreVaccinationDTO(centreDTO);
        centreVaccinationRepository.save(centre);

        return centreVaccinationMapper.fromCentreVaccination(centre);
    }

    @Override
    public CentreVaccinationDTO updateCentreVaccination(CentreVaccinationDTO centreDTO,Long longitude, Long latitude) {
        CoordonneDTO coordonneDTO=saveCoordonne(longitude,latitude);
        centreDTO.setCoordonneDTO(coordonneDTO);

        CentreVaccination centre=centreVaccinationMapper.fromCentreVaccinationDTO(centreDTO);
        centreVaccinationRepository.save(centre);

        return centreVaccinationMapper.fromCentreVaccination(centre);
    }

    @Override
    public void deleteCentreVaccination(Long centreId) {
        deleteCoordonne(centreId);
        centreVaccinationRepository.deleteById(centreId);
    }


    @Override
    public CoordonneDTO saveCoordonne(Long longitude, Long latitude) {
        Coordonnes coordonnes=new Coordonnes();
        coordonnes.setLatitude(latitude);
        coordonnes.setLongitude(longitude);
        return coordonneMapper.fromCoordonne(coordonnes);
    }

    @Override
    public void deleteCoordonne(Long coordId) {
        coordonnesRepository.deleteById(coordId);
    }
}
