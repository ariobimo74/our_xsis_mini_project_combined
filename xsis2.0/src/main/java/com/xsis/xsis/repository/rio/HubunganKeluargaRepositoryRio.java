package com.xsis.xsis.repository.rio;

import com.xsis.xsis.dto.rio.HubunganKeluargaDtoRio;
import com.xsis.xsis.model.rio.HubunganKeluargaEntityRio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HubunganKeluargaRepositoryRio extends JpaRepository<HubunganKeluargaEntityRio, Long>
{
    @Query(nativeQuery = true)
    List<HubunganKeluargaDtoRio> getTipeId(Long familyTreeTypeId);
}
