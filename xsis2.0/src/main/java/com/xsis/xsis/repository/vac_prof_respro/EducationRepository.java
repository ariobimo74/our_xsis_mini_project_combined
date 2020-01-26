package com.xsis.xsis.repository.vac_prof_respro;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.vac_prof_respro.Education;
import com.xsis.xsis.dto.vac_prof_respro.LastEduDto;
import com.xsis.xsis.dto.vac_prof_respro.EduDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PendidikanRepository
 */
public interface EducationRepository extends JpaRepository<Education, Long> {

    @Query(nativeQuery = true)
    List<EduDto> getEduName(Long biodataId);

    @Query(nativeQuery = true)
    List<LastEduDto> getLastEducation(Long biodataId);

    @Query(nativeQuery = true)
    Optional<EduDto> getEduNameDetail(Long biodataId, Long id);
}