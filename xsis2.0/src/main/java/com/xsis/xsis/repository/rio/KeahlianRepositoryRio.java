package com.xsis.xsis.repository.rio;

import com.xsis.xsis.dto.rio.KeahlianDtoRio;
import com.xsis.xsis.model.rio.KeahlianEntityRio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KeahlianRepositoryRio extends JpaRepository<KeahlianEntityRio, Long> {
    @Query(nativeQuery = true)
    List<KeahlianDtoRio> getBioId(Long biodataId);
}
