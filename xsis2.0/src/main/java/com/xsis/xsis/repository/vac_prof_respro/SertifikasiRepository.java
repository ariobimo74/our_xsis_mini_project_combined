package com.xsis.xsis.repository.vac_prof_respro;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.SertDto;
import com.xsis.xsis.model.vac_prof_respro.Sertifikasi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * SertifikasiRepository
 */
public interface SertifikasiRepository extends JpaRepository<Sertifikasi, Long>{

    @Query(nativeQuery = true)
    List<SertDto> getSertifikasiBiodata(Long biodataId);
    
}