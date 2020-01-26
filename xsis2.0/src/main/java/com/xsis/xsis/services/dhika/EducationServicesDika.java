package com.xsis.xsis.services.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.EducationDika;
import com.xsis.xsis.dto.dhika.EduDtoDika;

import org.springframework.data.repository.query.Param;

/**
 * PendidikanServices
 */
public interface EducationServicesDika {

    // Post Data Pendidikan Pelamar
    EducationDika saveEducation(EducationDika education);

    // Get List Data Pendidikan Pelamar
    Iterable<EducationDika> findAllEducation();

    // Get Data Pendidikan Pelamar
    Optional<EducationDika> getEducationById(@Param("id") Long id);

    // Education Join Education Level
    List<EduDtoDika> getEduName(Long biodataId);

    // Education Join Education Level Detail
    Optional<EduDtoDika> getEduNameDetail(Long biodataId, Long id);
}