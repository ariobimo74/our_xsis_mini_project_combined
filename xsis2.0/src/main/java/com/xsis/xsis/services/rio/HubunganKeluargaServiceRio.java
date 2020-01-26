package com.xsis.xsis.services.rio;

import com.xsis.xsis.dto.rio.HubunganKeluargaDtoRio;
import com.xsis.xsis.repository.rio.HubunganKeluargaRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HubunganKeluargaServiceRio
{
    @Autowired
    private HubunganKeluargaRepositoryRio hubunganKeluargaRepository;

    public List<HubunganKeluargaDtoRio> getTipeId(Long familyTreeTypeId)
    {
        return hubunganKeluargaRepository.getTipeId(familyTreeTypeId);
    }
}
