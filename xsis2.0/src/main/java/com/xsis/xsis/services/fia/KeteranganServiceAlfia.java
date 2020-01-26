package com.xsis.xsis.services.fia;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.fia.KeteranganBioDtoAlfia;
import com.xsis.xsis.model.fia.KeteranganAlfia;

/**
 * KeteranganService
 */
public interface KeteranganServiceAlfia {

    List<KeteranganAlfia> getAll();

    KeteranganAlfia getById(Long id);

    KeteranganAlfia save(KeteranganAlfia keterangan);

    KeteranganAlfia update(KeteranganAlfia keterangan);

    KeteranganAlfia delete(Long id);

    Optional<KeteranganBioDtoAlfia> getBioId(Long biodataId);
}