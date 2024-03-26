package com.uadb.vaccination.mappers;

import com.uadb.vaccination.dtos.RvDTO;
import com.uadb.vaccination.entities.Rv;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RvMapper {
    public RvDTO fromRv(Rv rv)
    {
        RvDTO rvDTO = new RvDTO();

        BeanUtils.copyProperties(rv, rvDTO);

        return rvDTO;
    }

    public Rv fromRvDTO(RvDTO rvDTO)
    {
        Rv rv = new Rv();

        BeanUtils.copyProperties(rvDTO, rv);

        return rv;
    }
}
