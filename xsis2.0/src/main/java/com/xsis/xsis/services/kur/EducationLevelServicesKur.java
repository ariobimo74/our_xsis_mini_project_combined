package com.xsis.xsis.services.kur;

import com.xsis.xsis.model.kur.EducationLevelKur;

/**
 * EducationLevelServices
 */
public interface EducationLevelServicesKur {

    // Get Data Tingkat Pendidikan
    Iterable<EducationLevelKur> getEducationLevel();

}