package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.LevelKeahlianEntityRio;
import com.xsis.xsis.repository.rio.LevelKeahlianRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/levelkeahlian")
public class LevelKeahlianRest
{
    @Autowired
    private LevelKeahlianRepositoryRio levelKeahlianRepository;

    @GetMapping
    public Iterable<LevelKeahlianEntityRio> findAllLevelKeahlian()
    {
        return levelKeahlianRepository.findAll();
    }
}
