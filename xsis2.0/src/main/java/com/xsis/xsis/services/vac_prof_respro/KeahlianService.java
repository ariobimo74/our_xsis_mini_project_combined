package com.xsis.xsis.services.vac_prof_respro;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.KeahDto;

/**
 * KeahlianService
 */
public interface KeahlianService {

    List<KeahDto> getKeahlianBiodata(Long biodataId);
    
}