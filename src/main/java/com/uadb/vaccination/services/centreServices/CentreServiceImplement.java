package com.uadb.vaccination.services.centreServices;

import com.uadb.vaccination.dtos.CentreVaccinationDTO;
import com.uadb.vaccination.dtos.CoordonneDTO;
import com.uadb.vaccination.dtos.UtilisateurDTO;
import com.uadb.vaccination.entities.CentreVaccination;
import com.uadb.vaccination.entities.Coordonnes;
import com.uadb.vaccination.entities.Utilisateur;
import com.uadb.vaccination.exception.CentreNotFoundException;
import com.uadb.vaccination.mappers.CentreVaccinationMapper;
import com.uadb.vaccination.mappers.CoordonneMapper;
import com.uadb.vaccination.mappers.UtilisateurMapper;
import com.uadb.vaccination.repositories.CentreVaccinationRepository;
import com.uadb.vaccination.repositories.CoordonnesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    UtilisateurMapper utilisateurMapper;

    @Override
    public List<CentreVaccinationDTO> getAllCentreVaccination() {
        //        return centres.stream().map(centre ->
//               {
//
//                   CentreVaccinationDTO centreDTO=centreVaccinationMapper.fromCentreVaccination(centre);
//
//                   List<UtilisateurDTO> listUserDTO=centre.getUtilisateurList().stream().map(
//                           user-> utilisateurMapper.fromUtilisateur(user)
//                   ).toList();
//
////                   listUserDTO.stream().map(user->centreDTO.getUtilisateurDTOListDTO().add(user));
//                   centreDTO.setUtilisateurDTOListDTO(listUserDTO);
//
//                   return centreDTO;
//               }
//                ).toList();
        List<CentreVaccination> centres= centreVaccinationRepository.findAll();
        List<CentreVaccinationDTO> centreDTOs=new ArrayList<>();

        for(CentreVaccination centre:centres)
        {
            CentreVaccinationDTO centreDTO=centreVaccinationMapper.fromCentreVaccination(centre);
            List<UtilisateurDTO> userDTOs=new ArrayList<>();

            for (Utilisateur user:centre.getUtilisateurList())
            {
                UtilisateurDTO userDTO=utilisateurMapper.fromUtilisateur(user);
                userDTOs.add(userDTO);
            }
            centreDTO.setUtilisateurDTOListDTO(userDTOs);

            centreDTOs.add(centreDTO);
        }

        return centreDTOs;
    }

    @Override
    public CentreVaccinationDTO getCentreVaccination(Long centreId) throws CentreNotFoundException {
        CentreVaccination centreVaccination = centreVaccinationRepository.findById(centreId)
                .orElseThrow(() ->new CentreNotFoundException("Centre est introuvable"));

        return centreVaccinationMapper.fromCentreVaccination(centreVaccination);
    }


    @Override
    public CentreVaccinationDTO saveCentreVaccination(CentreVaccinationDTO centreDTO,String longitude,String latitude) {
        CoordonneDTO coordonneDTO=saveCoordonne(longitude,latitude);

        centreDTO.setCoordonneDTO(coordonneDTO);

        CentreVaccination centre=centreVaccinationMapper.fromCentreVaccinationDTO(centreDTO);
        centreVaccinationRepository.save(centre);

        return centreVaccinationMapper.fromCentreVaccination(centre);
    }

    @Override
    public CentreVaccinationDTO updateCentreVaccination(CentreVaccinationDTO centreDTO,String longitude,String latitude) {
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
    public CoordonneDTO saveCoordonne(String longitude,String latitude) {
        Coordonnes coordonnes=new Coordonnes();
        coordonnes.setLatitude(latitude);
        coordonnes.setLongitude(longitude);
        coordonnesRepository.save(coordonnes);

        return coordonneMapper.fromCoordonne(coordonnes);
    }

    @Override
    public void deleteCoordonne(Long coordId) {
        coordonnesRepository.deleteById(coordId);
    }
}
