package com.uadb.vaccination.services.RendezVous;


import com.sun.source.doctree.ThrowsTree;
import com.uadb.vaccination.dtos.RvDTO;
import com.uadb.vaccination.entities.ENUM.EtatRv;
import com.uadb.vaccination.entities.Parent;
import com.uadb.vaccination.entities.Rv;
import com.uadb.vaccination.entities.Utilisateur;
import com.uadb.vaccination.exception.ParentNotFoundException;
import com.uadb.vaccination.exception.RvNotFoundException;
import com.uadb.vaccination.mappers.ParentMapper;
import com.uadb.vaccination.mappers.RvMapper;
import com.uadb.vaccination.mappers.UtilisateurMapper;
import com.uadb.vaccination.repositories.ParentRepository;
import com.uadb.vaccination.repositories.RvRepository;
import com.uadb.vaccination.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RendezVousServiceImplement implements RendezVousService{
    private RvMapper rvMapper;
    private UtilisateurMapper userMapper;
    private ParentMapper parentMapper;

    private RvRepository rvRepository;
    private UserRepository userRepository;
    private ParentRepository parentRepository;

    @Override
    public List<RvDTO> getAllRv(String emailUser) throws RvNotFoundException {
        List<Rv> rvList= rvRepository.findByUtilisateur_EmailOrderByIdDesc(emailUser);
        if (rvList==null)
            throw new RvNotFoundException("liste rv introuvable");

        List<RvDTO> rvListDTO=new ArrayList<>();
        for(Rv rv:rvList)
        {
            if(rv.getUtilisateur().getEmail().equals(emailUser))
            {
                rvListDTO.add(rvMapper.fromRv(rv));
            }
        }
        return rvListDTO;
    }

    @Override
    public RvDTO getRvDTO(Long rvId) {
        return null;
    }

    @Override
    public RvDTO saveRvDTO(RvDTO rvDTO, Long userId, Long telephone) throws ParentNotFoundException {
        Utilisateur utilisateur=userRepository.findById(userId)
                .orElseThrow(() -> new ParentNotFoundException("parent introuvable"));

        Parent parent= parentRepository.findByTelephone(telephone);
        if(parent == null)
            throw new ParentNotFoundException("numero de telephone du parent introuvable");

        //ajouter les rv dans la liste des rv du user recuperer
//        utilisateur.getRvs().add(rvMapper.fromRvDTO(rvDTO));
//        parent.setRv(rvMapper.fromRvDTO(rvDTO));\
        rvDTO.setEtatRv(EtatRv.ATTENTE_CONFIRMATION);
        rvDTO.setParentDTO(parentMapper.fromParent(parent));
        rvDTO.setUtilisateurDTO(userMapper.fromUtilisateur(utilisateur));
        Rv rv=rvMapper.fromRvDTO(rvDTO);
        Rv saveRv=rvRepository.save(rv);
        return rvMapper.fromRv(saveRv);
    }

    @Override
    public RvDTO updateRvDTO(RvDTO rvDTO) {
        Rv saveRv=rvRepository.save(rvMapper.fromRvDTO(rvDTO));
        return rvMapper.fromRv(saveRv);
    }

    @Override
    public void deleteRvDTO(Long rvId) {
        rvRepository.deleteById(rvId);
    }

    @Override
    public void confirmationRv(Long rvId) throws RvNotFoundException {
       Rv rv=rvRepository.findById(rvId)
               .orElseThrow(() -> new RvNotFoundException("rv introuvable"));
       rv.setEtatRv(EtatRv.CONFIRMER);
       rvRepository.save(rv);
    }

    @Override
    public void annulationRv(Long rvId) throws RvNotFoundException {
        Rv rv=rvRepository.findById(rvId)
                .orElseThrow(() -> new RvNotFoundException("rv introuvable"));
        rv.setEtatRv(EtatRv.ANNULER);
        rvRepository.save(rv);
    }

    @Override
    public void planifierRv(Long rvId, LocalDate newDate) throws RvNotFoundException {
        Rv rv=rvRepository.findById(rvId)
                .orElseThrow(() -> new RvNotFoundException("rv introuvable"));
        rv.setEtatRv(EtatRv.PLANIFIER);
        rv.setDateRv(newDate);
        rvRepository.save(rv);
    }

}
