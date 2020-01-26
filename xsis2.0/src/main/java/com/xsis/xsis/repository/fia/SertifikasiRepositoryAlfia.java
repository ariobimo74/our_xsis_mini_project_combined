package com.xsis.xsis.repository.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.SertifikasiBioDtoAlfia;
import com.xsis.xsis.model.fia.SertifikasiAlfia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Sertifikasi
 */
@Repository
public interface SertifikasiRepositoryAlfia extends JpaRepository<SertifikasiAlfia, Long> {
    @Query(nativeQuery = true)
    List<SertifikasiBioDtoAlfia> getBioId(Long biodataId);
}