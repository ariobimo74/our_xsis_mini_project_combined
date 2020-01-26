package com.xsis.xsis.services.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.fathan.DokumenDto;
import com.xsis.xsis.model.fathan.Dokumen;

/**
 * DokumenService
 */
public interface DokumenService {

    List<Dokumen> getAll();

    Optional<Dokumen> getById(Long id);

    Dokumen saveFile(Dokumen dokumen);

    Dokumen saveFoto(Dokumen dokumen);

    Dokumen edit(Dokumen dokumen);

    Dokumen delete(Long id);

    List<DokumenDto> getBioId(Long biodataId);

    Long getBiodataIdFile(Dokumen dokumen);

}