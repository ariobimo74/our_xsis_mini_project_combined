package com.xsis.xsis.services.vac_prof_respro.implementation;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.PeKerDto;
import com.xsis.xsis.repository.vac_prof_respro.PengalamanKerjaRepository;
import com.xsis.xsis.services.vac_prof_respro.PengalamanKerjaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PengalamanKerjaServicesImpl
 */
@Service
public class PengalamanKerjaServicesImpl implements PengalamanKerjaServices {

    @Autowired
    private PengalamanKerjaRepository pengalamanKerjaRepository;

    @Override
    public List<PeKerDto> getPengalamanKerjaBiodata(Long biodataId) {
        return pengalamanKerjaRepository.getPengalamanKerjaBiodata(biodataId);
    }
}