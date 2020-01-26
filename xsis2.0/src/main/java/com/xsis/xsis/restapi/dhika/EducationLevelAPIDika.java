package com.xsis.xsis.restapi.dhika;

import com.xsis.xsis.model.dhika.EducationLevelDika;
import com.xsis.xsis.services.dhika.EducationLevelServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EducationLevelAPI
 */
@RestController
@RequestMapping(path = "/api/education-level-dika", produces = "application/json")
@CrossOrigin(origins = "*")
public class EducationLevelAPIDika {

    @Autowired
    private EducationLevelServicesDika educationLevelServices;

    @GetMapping
    public Iterable<EducationLevelDika> findAllEducationLevel() {
        return educationLevelServices.getEducationLevel();
    }

}