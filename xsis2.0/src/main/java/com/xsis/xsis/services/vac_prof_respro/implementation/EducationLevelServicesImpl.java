package com.xsis.xsis.services.vac_prof_respro.implementation;

import com.xsis.xsis.model.vac_prof_respro.EducationLevel;
import com.xsis.xsis.repository.vac_prof_respro.EducationLevelRepository;
import com.xsis.xsis.services.vac_prof_respro.EducationLevelServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EducationLevelServicesImpl
 */
@Service
public class EducationLevelServicesImpl implements EducationLevelServices {

    @Autowired
    private EducationLevelRepository educationLevelRepository;

    @Override
    public Iterable<EducationLevel> getEducationLevel() {
        return educationLevelRepository.getEducationLevel();
    }

}