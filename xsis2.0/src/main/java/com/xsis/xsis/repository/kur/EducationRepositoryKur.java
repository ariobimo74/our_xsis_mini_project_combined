package com.xsis.xsis.repository.kur;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.kur.EducationKur;
import com.xsis.xsis.dto.kur.EduDtoKur;
import com.xsis.xsis.dto.kur.NameLastEducationDtoKur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PendidikanRepository
 */
public interface EducationRepositoryKur extends JpaRepository<EducationKur, Long> {

    @Query(nativeQuery = true)
    List<EduDtoKur> getEduName(Long biodataId);

    @Query(nativeQuery = true)
    List<EduDtoKur> getLastEducation(Long biodataId);

    @Query(nativeQuery = true)
    Optional<EduDtoKur> getEduNameDetail(Long biodataId, Long id);

    @Query(nativeQuery = true)
    List<NameLastEducationDtoKur> getNameLastEducation(Long biodataId);
}