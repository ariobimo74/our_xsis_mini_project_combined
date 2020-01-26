package com.xsis.xsis.services.kur.Implementation;

import com.xsis.xsis.model.kur.EducationLevelKur;
import com.xsis.xsis.repository.kur.EducationLevelRepositoryKur;
import com.xsis.xsis.services.kur.EducationLevelServicesKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EducationLevelServicesImpl
 */
@Service
public class EducationLevelServicesImplKur implements EducationLevelServicesKur {

    @Autowired
    private EducationLevelRepositoryKur educationLevelRepositoryKur;

    @Override
    public Iterable<EducationLevelKur> getEducationLevel() {
        return educationLevelRepositoryKur.findAll();
    }

}