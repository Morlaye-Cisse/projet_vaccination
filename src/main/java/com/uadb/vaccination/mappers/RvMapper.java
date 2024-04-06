package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.RvDTO;
import com.uadb.vaccination.entities.Rv;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RvMapper {
    ParentMapper parentMapper;
    UtilisateurMapper utilisateurMapper;
    public RvDTO fromRv(Rv rv)
    {
        RvDTO rvDTO = new RvDTO();
        BeanUtils.copyProperties(rv, rvDTO);

        rvDTO.setParentDTO(parentMapper.fromParent(rv.getParent()));
        rvDTO.setUtilisateurDTO(utilisateurMapper.fromUtilisateur(rv.getUtilisateur()));
        return rvDTO;
    }

    public Rv fromRvDTO(RvDTO rvDTO)
    {
        Rv rv = new Rv();
        BeanUtils.copyProperties(rvDTO, rv);
        rv.setParent(parentMapper.fromParentDTO(rvDTO.getParentDTO()));
        rv.setUtilisateur(utilisateurMapper.fromUtilisateurDTO(rvDTO.getUtilisateurDTO()));

        return rv;
    }
}
