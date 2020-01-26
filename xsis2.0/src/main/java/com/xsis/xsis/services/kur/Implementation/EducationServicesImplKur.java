package com.xsis.xsis.services.kur.Implementation;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.kur.EduDtoKur;
import com.xsis.xsis.dto.kur.NameLastEducationDtoKur;
import com.xsis.xsis.model.kur.EducationKur;
import com.xsis.xsis.repository.kur.EducationRepositoryKur;
import com.xsis.xsis.services.kur.EducationServicesKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PendidikanServicesImpl
 */
@Service
public class EducationServicesImplKur implements EducationServicesKur {

    @Autowired
    private EducationRepositoryKur educationRepositoryKur;

    @Override
    public EducationKur saveEducation(EducationKur education) {
        return educationRepositoryKur.save(education);
    }

    @Override
    public Optional<EducationKur> getEducationById(Long id) {
        return educationRepositoryKur.findById(id);
    }

    @Override
    public Iterable<EducationKur> findAllEducation() {
        return educationRepositoryKur.findAll();
    }

    @Override
    public List<EduDtoKur> getEduName(Long biodataId) {
        return educationRepositoryKur.getEduName(biodataId);
    }

    @Override
    public Optional<EduDtoKur> getEduNameDetail(Long biodataId, Long id) {
        return educationRepositoryKur.getEduNameDetail(biodataId, id);
    }

    @Override
    public List<EduDtoKur> getLastEducation(Long biodataId) {
        return educationRepositoryKur.getLastEducation(biodataId);
    }

    @Override
    public List<NameLastEducationDtoKur> getNameLastEdu(Long biodataId) {
        return educationRepositoryKur.getNameLastEducation(biodataId);
    }

}