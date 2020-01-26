package com.xsis.xsis.services.vac_prof_respro.implementation;

import java.util.Optional;

import com.xsis.xsis.dto.vac_prof_respro.BioAttchDto;
import com.xsis.xsis.repository.vac_prof_respro.BiodataAttachmentRepository;
import com.xsis.xsis.services.vac_prof_respro.BiodataAttachmentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BiodataAttachmentServicesImpl
 */
@Service
public class BiodataAttachmentServicesImpl implements BiodataAttachmentServices {

    @Autowired
    private BiodataAttachmentRepository biodataAttachmentRepository;

    @Override
    public Optional<BioAttchDto> getBiodataAttachment(Long biodataId) {
        return biodataAttachmentRepository.getBiodataAttachment(biodataId);
    }
    
}