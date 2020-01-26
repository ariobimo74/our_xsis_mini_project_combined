package com.xsis.xsis.services.vac_prof_respro.implementation;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.TraiDto;
import com.xsis.xsis.repository.vac_prof_respro.TrainingRepository;
import com.xsis.xsis.services.vac_prof_respro.TrainingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TrainingServicesImpl
 */
@Service
public class TrainingServicesImpl implements TrainingServices {

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public List<TraiDto> getTrainingBiodata(Long biodataId) {
        return trainingRepository.getTrainingBiodata(biodataId);
    }
}