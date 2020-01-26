package com.xsis.xsis.services.vac_prof_respro;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.TraiDto;

/**
 * TrainingServices
 */
public interface TrainingServices {

    List<TraiDto> getTrainingBiodata(Long biodataId);
    
}