package com.xsis.xsis.services.vac_prof_respro.implementation;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.vac_prof_respro.EduDto;
import com.xsis.xsis.model.vac_prof_respro.Education;
import com.xsis.xsis.dto.vac_prof_respro.LastEduDto;
import com.xsis.xsis.repository.vac_prof_respro.EducationRepository;
import com.xsis.xsis.services.vac_prof_respro.EducationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PendidikanServicesImpl
 */
@Service
public class EducationServicesImpl implements EducationServices {

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public Education saveEducation(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public Optional<Education> getEducationById(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    public Iterable<Education> findAllEducation() {
        return educationRepository.findAll();
    }

    @Override
    public List<EduDto> getEduName(Long biodataId) {
        return educationRepository.getEduName(biodataId);
    }

    @Override
    public Optional<EduDto> getEduNameDetail(Long biodataId, Long id) {
        return educationRepository.getEduNameDetail(biodataId, id);
    }

    @Override
    public List<LastEduDto> getLastEducation(Long biodataId) {
        return educationRepository.getLastEducation(biodataId);
    }

}