package com.xsis.xsis.repository.rio;


import com.xsis.xsis.dto.rio.CatatanDtoRio;
import com.xsis.xsis.model.rio.CatatanEntityRio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatatanRepositoryRio extends JpaRepository<CatatanEntityRio, Long>
{
    @Query(nativeQuery = true)
    List<CatatanDtoRio> getBioId(int biodataId);
}
