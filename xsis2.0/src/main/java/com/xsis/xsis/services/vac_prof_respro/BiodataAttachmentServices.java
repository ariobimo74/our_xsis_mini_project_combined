package com.xsis.xsis.services.vac_prof_respro;

import java.util.Optional;

import com.xsis.xsis.dto.vac_prof_respro.BioAttchDto;

/**
 * BiodataAttachmentServices
 */
public interface BiodataAttachmentServices {

    Optional<BioAttchDto> getBiodataAttachment(Long biodataId);
}