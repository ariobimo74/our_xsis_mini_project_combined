package com.xsis.xsis.repository.vac_prof_respro;

import java.util.Optional;

import com.xsis.xsis.dto.vac_prof_respro.BioAttchDto;
import com.xsis.xsis.model.vac_prof_respro.BiodataAttch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * BiodataAttachmentRepository
 */
public interface BiodataAttachmentRepository extends JpaRepository <BiodataAttch, Long>{

    @Query(nativeQuery = true)
    Optional<BioAttchDto> getBiodataAttachment(Long biodataId);
}