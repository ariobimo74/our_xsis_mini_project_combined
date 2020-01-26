package com.xsis.xsis.repository.vac_prof_respro;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.KeahDto;
import com.xsis.xsis.model.vac_prof_respro.Keahlian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * KeahlianRepository
 */
public interface KeahlianRepository extends JpaRepository<Keahlian, Long> {

    @Query(nativeQuery = true)
    List<KeahDto> getKeahlianBiodata(Long biodataId);
    
}