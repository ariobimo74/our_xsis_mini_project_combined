package com.xsis.xsis.services.vac_prof_respro;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.PeKerDto;

/**
 * PengalamanKerjaServices
 */
public interface PengalamanKerjaServices {

    List<PeKerDto> getPengalamanKerjaBiodata(Long biodataId);
    
}