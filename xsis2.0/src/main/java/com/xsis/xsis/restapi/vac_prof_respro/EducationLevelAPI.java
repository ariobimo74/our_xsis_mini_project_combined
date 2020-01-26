package com.xsis.xsis.restapi.vac_prof_respro;

import com.xsis.xsis.model.vac_prof_respro.EducationLevel;
import com.xsis.xsis.services.vac_prof_respro.EducationLevelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EducationLevelAPI
 */
@RestController
@RequestMapping(path = "/api/education-level", produces = "application/json")
@CrossOrigin(origins = "*")
public class EducationLevelAPI {

    @Autowired
    private EducationLevelServices educationLevelServices;

    @GetMapping
    public Iterable<EducationLevel> findAllEducationLevel() {
        return educationLevelServices.getEducationLevel();
    }
    
}