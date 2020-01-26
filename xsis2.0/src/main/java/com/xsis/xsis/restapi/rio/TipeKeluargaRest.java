package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.TipeKeluargaEntityRio;
import com.xsis.xsis.repository.rio.TipeKeluargaRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/tipekeluarga")
public class TipeKeluargaRest
{
    @Autowired
    private TipeKeluargaRepositoryRio tipeKeluargaRepository;

    @GetMapping
    public Iterable<TipeKeluargaEntityRio> findAllTipeKeluarga()
    {
        return tipeKeluargaRepository.findAll();
    }
}
