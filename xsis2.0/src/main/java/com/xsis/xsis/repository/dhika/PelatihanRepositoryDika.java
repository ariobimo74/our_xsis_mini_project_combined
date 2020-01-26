package com.xsis.xsis.repository.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.dhika.pelatihanDtoDika;
import com.xsis.xsis.model.dhika.PelatihanDika;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PelatihanRepository
 */
@Repository
public interface PelatihanRepositoryDika extends JpaRepository<PelatihanDika, Long> {

    @Query(nativeQuery = true)
    List<pelatihanDtoDika> getPelatihan(Long biodataId);

    @Query(nativeQuery = true)
    Optional<pelatihanDtoDika> getPelatihanDetail(Long biodataId, Long id);

}