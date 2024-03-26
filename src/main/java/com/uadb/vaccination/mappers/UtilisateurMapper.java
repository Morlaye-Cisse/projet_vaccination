package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.UtilisateurDTO;
import com.uadb.vaccination.entities.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UtilisateurMapper {

    CentreVaccinationMapper centreVaccinationMapper;
    public UtilisateurDTO fromUtilisateur(Utilisateur user)
    {
        UtilisateurDTO userDTO=new UtilisateurDTO();
        BeanUtils.copyProperties(user,userDTO);
        userDTO.setCentreVaccinationDTO(centreVaccinationMapper.fromCentreVaccination(user.getCentreVaccination()));

        return userDTO;
    }

    public Utilisateur fromUtilisateurDTO(UtilisateurDTO userDTO)
    {
        Utilisateur user=new Utilisateur();
        BeanUtils.copyProperties(userDTO,user);
        user.setCentreVaccination(centreVaccinationMapper.fromCentreVaccinationDTO(userDTO.getCentreVaccinationDTO()));

        return user;
    }
}
