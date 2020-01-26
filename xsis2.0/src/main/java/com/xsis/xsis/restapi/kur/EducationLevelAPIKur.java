package com.xsis.xsis.restapi.kur;

import com.xsis.xsis.model.kur.EducationLevelKur;
import com.xsis.xsis.services.kur.EducationLevelServicesKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EducationLevelAPI
 */
@RestController
@RequestMapping(path = "/api/education-level-ku", produces = "application/json")
@CrossOrigin(origins = "*")
public class EducationLevelAPIKur {

    @Autowired
    private EducationLevelServicesKur educationLevelServicesKur;

    @GetMapping
    public Iterable<EducationLevelKur> findAllEducationLevel() {
        return educationLevelServicesKur.getEducationLevel();
    }

}