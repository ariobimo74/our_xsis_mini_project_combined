package com.xsis.xsis.repository.rio;

import com.xsis.xsis.dto.rio.KeluargaDtoRio;
import com.xsis.xsis.model.rio.KeluargaEntityRio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KeluargaRepositoryRio extends JpaRepository<KeluargaEntityRio, Long>
{
      @Query(nativeQuery = true)
      List<KeluargaDtoRio> getBioId(int biodataId);
}
