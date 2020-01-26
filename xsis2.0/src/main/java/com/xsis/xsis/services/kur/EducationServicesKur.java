package com.xsis.xsis.services.kur;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.kur.EducationKur;
import com.xsis.xsis.dto.kur.EduDtoKur;
import com.xsis.xsis.dto.kur.NameLastEducationDtoKur;

import org.springframework.data.repository.query.Param;

/**
 * PendidikanServices
 */
public interface EducationServicesKur {

    // Post Data Pendidikan Pelamar
    EducationKur saveEducation(EducationKur education);

    // Get List Data Pendidikan Pelamar
    Iterable<EducationKur> findAllEducation();

    // Get Data Pendidikan Pelamar
    Optional<EducationKur> getEducationById(@Param("id") Long id);

    // Education Join Education Level
    List<EduDtoKur> getEduName(Long biodataId);

    // Education Join Education Level Detail
    Optional<EduDtoKur> getEduNameDetail(Long biodataId, Long id);

    // Get Last Education By Biodata
    List<EduDtoKur> getLastEducation(Long biodataId);

    List<NameLastEducationDtoKur> getNameLastEdu(Long biodataId);
}