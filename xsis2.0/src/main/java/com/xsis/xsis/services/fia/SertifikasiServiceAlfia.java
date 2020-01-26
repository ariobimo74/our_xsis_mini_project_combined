package com.xsis.xsis.services.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.SertifikasiBioDtoAlfia;
import com.xsis.xsis.model.fia.SertifikasiAlfia;

/**
 * SertifikasiService
 */
public interface SertifikasiServiceAlfia {

    List<SertifikasiAlfia> getAll();

    SertifikasiAlfia getById(Long id);

    SertifikasiAlfia save(SertifikasiAlfia sertifikasi);

    SertifikasiAlfia update(SertifikasiAlfia sertifikasi);

    SertifikasiAlfia delete(Long id);

    List<SertifikasiBioDtoAlfia> getBioId(Long biodataId);
}