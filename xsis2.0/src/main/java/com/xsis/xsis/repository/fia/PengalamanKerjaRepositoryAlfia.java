package com.xsis.xsis.repository.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.BiodataPengkerDtoAlfia;
import com.xsis.xsis.model.fia.PengalamanKerjaAlfia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PengalamanKerjaRepository
 */
public interface PengalamanKerjaRepositoryAlfia extends JpaRepository<PengalamanKerjaAlfia, Long> {
    @Query(nativeQuery = true)
    List<BiodataPengkerDtoAlfia> getBioId(Long biodataId);

}