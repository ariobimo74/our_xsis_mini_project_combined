package com.xsis.xsis.repository.fathan;

import java.util.List;

import com.xsis.xsis.model.fathan.Organisasi;
import com.xsis.xsis.dto.fathan.OrganisasiDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * OrganisasiRepository
 */
public interface OrganisasiRepository extends JpaRepository<Organisasi, Long> {

    @Query(nativeQuery = true)
    List<OrganisasiDto> getBioId(Long biodataId);
}