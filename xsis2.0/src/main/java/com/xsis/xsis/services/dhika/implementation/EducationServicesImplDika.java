package com.xsis.xsis.services.dhika.implementation;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.dhika.EduDtoDika;
import com.xsis.xsis.model.dhika.EducationDika;
import com.xsis.xsis.repository.dhika.EducationRepositoryDika;
import com.xsis.xsis.services.dhika.EducationServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PendidikanServicesImpl
 */
@Service
public class EducationServicesImplDika implements EducationServicesDika {

    @Autowired
    private EducationRepositoryDika educationRepository;

    @Override
    public EducationDika saveEducation(EducationDika education) {
        return educationRepository.save(education);
    }

    @Override
    public Optional<EducationDika> getEducationById(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    public Iterable<EducationDika> findAllEducation() {
        return educationRepository.findAll();
    }

    @Override
    public List<EduDtoDika> getEduName(Long biodataId) {
        return educationRepository.getEduNameDika(biodataId);
    }

    @Override
    public Optional<EduDtoDika> getEduNameDetail(Long biodataId, Long id) {
        return educationRepository.getEduNameDetailDika(biodataId, id);
    }

}