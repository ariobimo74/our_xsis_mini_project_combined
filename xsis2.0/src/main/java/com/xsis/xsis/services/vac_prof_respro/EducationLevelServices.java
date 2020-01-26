package com.xsis.xsis.services.vac_prof_respro;

import com.xsis.xsis.model.vac_prof_respro.EducationLevel;


/**
 * EducationLevelServices
 */
public interface EducationLevelServices {

    //Get Data Tingkat Pendidikan
    Iterable<EducationLevel> getEducationLevel();
    
}