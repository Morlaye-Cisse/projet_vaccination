package com.uadb.vaccination.services.userServices;


import com.uadb.vaccination.dtos.CentreVaccinationDTO;
import com.uadb.vaccination.dtos.UtilisateurDTO;
import com.uadb.vaccination.entities.CentreVaccination;
import com.uadb.vaccination.entities.Utilisateur;
import com.uadb.vaccination.exception.CentreNotFoundException;
import com.uadb.vaccination.exception.UserNotFoundException;
import com.uadb.vaccination.mappers.CentreVaccinationMapper;
import com.uadb.vaccination.mappers.UtilisateurMapper;
import com.uadb.vaccination.repositories.CentreVaccinationRepository;
import com.uadb.vaccination.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
//anotation pour la gestion des journalisation
@Slf4j
public class UserServiceImplement implements UserService {
    private final CentreVaccinationRepository centreVaccinationRepository;
    private final UserRepository userRepository;
    private UtilisateurMapper utilisateurMapper;
    private CentreVaccinationMapper centreVaccinationMapper;


    @Override
    public UtilisateurDTO saveUser(UtilisateurDTO utilisateurDTO,Long centreId) throws CentreNotFoundException {
        //Si le user est ROLE_ADMIN
             //recuperation du centre en fonction du id sectionner
        //Si le user est medecin
            //recuperation du centre en fonction du cemtre du medecin

        CentreVaccination centre=centreVaccinationRepository.findById(centreId)
                    .orElseThrow(() -> new CentreNotFoundException("centre vaccination introuvable"));

        CentreVaccinationDTO centreDTO=centreVaccinationMapper.fromCentreVaccination(centre);
        utilisateurDTO.setCentreVaccinationDTO(centreDTO);


        //transfere des donnees de userDTO ver user
        Utilisateur utilisateur=utilisateurMapper.fromUtilisateurDTO(utilisateurDTO);

        centre.getUtilisateurList().add(utilisateur);

        //enregistrer user
        Utilisateur saveUser=userRepository.save(utilisateur);

        //retourner utilisateurDTO
        return utilisateurMapper.fromUtilisateur(saveUser);
    }

    @Override
    public List<UtilisateurDTO> getAllUsers() {
        List<Utilisateur> utilisateurs= userRepository.findAll();

        return utilisateurs.stream().map(user->utilisateurMapper.fromUtilisateur(user))
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDTO getUser(Long userId) throws UserNotFoundException {
        Utilisateur utilisateur=userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable"));

        return utilisateurMapper.fromUtilisateur(utilisateur);
    }

    @Override
    public UtilisateurDTO updateUser(UtilisateurDTO utilisateurDTO) {
        log.info("Modeifier utilisateur");

        Utilisateur utilisateur=utilisateurMapper.fromUtilisateurDTO(utilisateurDTO);
        Utilisateur updateUser=userRepository.save(utilisateur);

        return utilisateurMapper.fromUtilisateur(updateUser);
    }

    @Override
    public void deleteUser(Long userId) {
        log.info("Supprimer un utilisateur");
        userRepository.deleteById(userId);
    }

    @Override
    public List<UtilisateurDTO> getUserSearch(String email, String telephone) {

        List<Utilisateur> utilisateurs= userRepository.findByEmailContainsIgnoreCaseAndTelephoneContainsIgnoreCase(email,telephone);
        //recuperer la liste a partir du telephone
//        List<Utilisateur> utilisateurs= userRepository.findByTelephoneContainsIgnoreCase(telephone);

        return utilisateurs.stream().map(user->utilisateurMapper.fromUtilisateur(user))
                .collect(Collectors.toList());
    }
}
