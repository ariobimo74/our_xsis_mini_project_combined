package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.TipeCatatanEntityRio;
import com.xsis.xsis.repository.rio.TipeCatatanRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/tipecatatan")
public class TipeCatatanRest
{
    @Autowired
    private TipeCatatanRepositoryRio tipeCatatanRepository;

    @GetMapping
    public Iterable<TipeCatatanEntityRio> findAllTipeCatatan()
    {
        return tipeCatatanRepository.findAll();
    }
}
