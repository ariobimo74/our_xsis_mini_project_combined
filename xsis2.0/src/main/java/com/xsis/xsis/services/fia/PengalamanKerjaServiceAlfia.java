package com.xsis.xsis.services.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.BiodataPengkerDtoAlfia;
import com.xsis.xsis.model.fia.PengalamanKerjaAlfia;

/**
 * PengalamanKerjaService
 */
public interface PengalamanKerjaServiceAlfia {

    List<PengalamanKerjaAlfia> getAll();

    PengalamanKerjaAlfia getById(Long id);

    PengalamanKerjaAlfia save(PengalamanKerjaAlfia pengalamanKerja);

    PengalamanKerjaAlfia update(PengalamanKerjaAlfia pengalamanKerja);

    PengalamanKerjaAlfia delete(Long id);

    List<BiodataPengkerDtoAlfia> getBioId(Long biodataId);

}