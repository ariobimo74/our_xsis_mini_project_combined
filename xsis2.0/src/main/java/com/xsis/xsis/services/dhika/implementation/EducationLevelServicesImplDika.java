package com.xsis.xsis.services.dhika.implementation;

import com.xsis.xsis.model.dhika.EducationLevelDika;
import com.xsis.xsis.repository.dhika.EducationLevelRepositoryDika;
import com.xsis.xsis.services.dhika.EducationLevelServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EducationLevelServicesImpl
 */
@Service
public class EducationLevelServicesImplDika implements EducationLevelServicesDika {

    @Autowired
    private EducationLevelRepositoryDika educationLevelRepository;

    @Override
    public Iterable<EducationLevelDika> getEducationLevel() {
        return educationLevelRepository.findAll();
    }

}