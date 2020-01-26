package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.LevelPendidikanEntityRio;
import com.xsis.xsis.repository.rio.LevelPendidikanRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/levelpendidikan")
public class LevelPendidikanRest
{
    @Autowired
    private LevelPendidikanRepositoryRio levelPendidikanRepository;

    @GetMapping
    public Iterable<LevelPendidikanEntityRio> findAllLevelPendidikan()
    {
        return levelPendidikanRepository.findAll();
    }
}
