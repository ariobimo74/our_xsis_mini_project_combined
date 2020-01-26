package com.xsis.xsis.services.vac_prof_respro.implementation;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.SertDto;
import com.xsis.xsis.repository.vac_prof_respro.SertifikasiRepository;
import com.xsis.xsis.services.vac_prof_respro.SertifikasiServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SertifikasiServicesImpl
 */
@Service
public class SertifikasiServicesImpl implements SertifikasiServices {

    @Autowired
    private SertifikasiRepository sertifikasiRepository;

    @Override
    public List<SertDto> getSertifikasiBiodata(Long biodataId) {
        return sertifikasiRepository.getSertifikasiBiodata(biodataId);
    }
    
}