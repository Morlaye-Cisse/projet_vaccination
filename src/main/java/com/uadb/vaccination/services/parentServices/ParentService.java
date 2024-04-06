package com.uadb.vaccination.services.parentServices;

import com.uadb.vaccination.dtos.ParentDTO;
import com.uadb.vaccination.entities.Parent;
import com.uadb.vaccination.exception.ParentNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentService {
//    ParentDTO saveParent(ParentDTO parentDTO);
    ParentDTO saveParent(ParentDTO parentDTO, String userEmail) throws ParentNotFoundException;
    List<ParentDTO> getAllParentsDTO();
    ParentDTO getParentDTO(Long parentId) throws ParentNotFoundException;
    ParentDTO updateParentDTO(ParentDTO parentDTO);
    void deleteParentDTO(Long parentId);
}
