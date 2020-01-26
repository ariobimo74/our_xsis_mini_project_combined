package com.xsis.xsis.services.vac_prof_respro;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.SertDto;

/**
 * SertifikasiServices
 */
public interface SertifikasiServices {

    List<SertDto> getSertifikasiBiodata(Long biodataId);

}