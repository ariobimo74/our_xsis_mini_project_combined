package com.xsis.xsis.repository.vac_prof_respro;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.PeKerDto;
import com.xsis.xsis.model.vac_prof_respro.PengalamanKerja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PengalamanKerjaRepository
 */
public interface PengalamanKerjaRepository extends JpaRepository<PengalamanKerja, Long>{

    @Query(nativeQuery = true)
    List<PeKerDto> getPengalamanKerjaBiodata(Long biodataId);
    
}