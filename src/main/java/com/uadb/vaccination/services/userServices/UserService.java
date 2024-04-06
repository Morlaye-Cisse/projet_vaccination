package com.uadb.vaccination.services.userServices;

import com.uadb.vaccination.dtos.UtilisateurDTO;
import com.uadb.vaccination.dtos.UtilisateurSearchDTO;
import com.uadb.vaccination.exception.CentreNotFoundException;
import com.uadb.vaccination.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    UtilisateurDTO saveUser(UtilisateurDTO utilisateurDTO,Long centreId) throws CentreNotFoundException;
    List<UtilisateurDTO> getAllUsers();
    UtilisateurDTO getUser(Long userId) throws UserNotFoundException;
    UtilisateurDTO updateUser(UtilisateurDTO utilisateurDTO);
    void deleteUser(Long userId);
    List<UtilisateurDTO> getUserSearch(String email, Long telephone);
}
