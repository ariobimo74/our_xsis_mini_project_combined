package com.xsis.xsis.repository.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.ProyekBioDtoAlfia;
import com.xsis.xsis.model.fia.RiwayatProyekAlfia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * ProyekRepository
 */
@Repository
public interface ProyekRepositoryAlfia extends JpaRepository<RiwayatProyekAlfia, Long> {
    @Query(nativeQuery = true)
    List<ProyekBioDtoAlfia> getPengkerId(Long riwayatPekerjaanId);
}