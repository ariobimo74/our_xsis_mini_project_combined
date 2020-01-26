package com.xsis.xsis.services.kur;

import java.util.List;

import com.xsis.xsis.dto.kur.BiodataPengkerDtoKur;
import com.xsis.xsis.model.kur.entity.PengalamanKerjaKur;

/**
 * PengalamanKerjaService
 */
public interface PengalamanKerjaServiceKur {

    List<PengalamanKerjaKur> getAll();

    PengalamanKerjaKur getById(Long id);

    PengalamanKerjaKur save(PengalamanKerjaKur pengalamanKerja);

    PengalamanKerjaKur update(PengalamanKerjaKur pengalamanKerja);

    PengalamanKerjaKur delete(Long id);

    List<BiodataPengkerDtoKur> getBioId(Long biodataId);

}