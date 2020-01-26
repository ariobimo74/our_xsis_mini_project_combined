package com.xsis.xsis.services.vac_prof_respro.implementation;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.KeahDto;
import com.xsis.xsis.repository.vac_prof_respro.KeahlianRepository;
import com.xsis.xsis.services.vac_prof_respro.KeahlianService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * KeahlianServiceImpl
 */
@Service
public class KeahlianServiceImpl implements KeahlianService {

    @Autowired
    private KeahlianRepository keahlianRepository;

    @Override
    public List<KeahDto> getKeahlianBiodata(Long biodataId) {
        return keahlianRepository.getKeahlianBiodata(biodataId);
    }

    
}