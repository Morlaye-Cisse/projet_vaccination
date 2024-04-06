package com.uadb.vaccination.webController;

import com.uadb.vaccination.dtos.UtilisateurDTO;
import com.uadb.vaccination.exception.CentreNotFoundException;
import com.uadb.vaccination.exception.UserNotFoundException;
import com.uadb.vaccination.services.userServices.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    UserService userService;

    //recuperation de tous les users
    @GetMapping("/users")
    public List<UtilisateurDTO> getAllUsersDTO()
    {
        return userService.getAllUsers();
    }

    //recuperation de l'user en fonction de l'id
    @GetMapping("/users/{id}")
    public UtilisateurDTO getUserDTO(@PathVariable(name = "id") Long userId) throws UserNotFoundException {
        return userService.getUser(userId);
    }

    //Enregistrement d'un utilisateur
    @PostMapping("/users/{idCentre}")
    public UtilisateurDTO saveUserDTO(@RequestBody UtilisateurDTO utilisateurDTO,@PathVariable Long idCentre) throws CentreNotFoundException {
        return userService.saveUser(utilisateurDTO,idCentre);
    }

    @PutMapping("/users/{id}")
    public UtilisateurDTO updateUserDTO(@PathVariable Long id,@RequestBody UtilisateurDTO utilisateurDTO)
    {
        utilisateurDTO.setId(id);
        return userService.updateUser(utilisateurDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(name = "id") Long userId)
    {
        userService.deleteUser(userId);
    }
    @GetMapping("/users/search")
    public List<UtilisateurDTO> getUserSearch(@RequestParam(name = "email", defaultValue = "") String email,@RequestParam(name = "telephone", defaultValue = "") Long telephone)
    {
        return userService.getUserSearch(email,telephone);
    }
}
