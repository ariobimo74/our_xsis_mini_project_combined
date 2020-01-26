package com.xsis.xsis.repository.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.EducationDika;
import com.xsis.xsis.dto.dhika.EduDtoDika;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PendidikanRepository
 */
public interface EducationRepositoryDika extends JpaRepository<EducationDika, Long> {

    @Query(nativeQuery = true)
    List<EduDtoDika> getEduNameDika(Long biodataId);

    @Query(nativeQuery = true)
    Optional<EduDtoDika> getEduNameDetailDika(Long biodataId, Long id);
}