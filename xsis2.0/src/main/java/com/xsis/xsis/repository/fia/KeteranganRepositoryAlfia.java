package com.xsis.xsis.repository.fia;

import java.util.Optional;

import com.xsis.xsis.dto.fia.KeteranganBioDtoAlfia;
import com.xsis.xsis.model.fia.KeteranganAlfia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * KeteranganRepository
 */
@Repository
public interface KeteranganRepositoryAlfia extends JpaRepository<KeteranganAlfia, Long> {
    @Query(nativeQuery = true)
    Optional<KeteranganBioDtoAlfia> getBioId(Long biodataId);
}