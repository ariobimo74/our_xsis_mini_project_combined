package com.xsis.xsis.repository.fathan;

import java.util.List;

import com.xsis.xsis.dto.fathan.DokumenDto;
import com.xsis.xsis.model.fathan.Dokumen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * DokumenRepository
 */
public interface DokumenRepository extends JpaRepository<Dokumen, Long> {
    @Query(nativeQuery = true)
    List<DokumenDto> getBioId(Long biodataId);
}