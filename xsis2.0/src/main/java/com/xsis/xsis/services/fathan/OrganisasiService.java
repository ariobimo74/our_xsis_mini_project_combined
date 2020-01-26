package com.xsis.xsis.services.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.fathan.OrganisasiDto;
import com.xsis.xsis.model.fathan.Organisasi;

/**
 * OrganisasiService
 */
public interface OrganisasiService {

    List<Organisasi> getAll();

    Optional<Organisasi> getById(Long id);

    Organisasi save(Organisasi organisasi);

    Organisasi edit(Organisasi organisasi);

    Organisasi delete(Long id);

    List<OrganisasiDto> getBioId(Long biodataId);

}