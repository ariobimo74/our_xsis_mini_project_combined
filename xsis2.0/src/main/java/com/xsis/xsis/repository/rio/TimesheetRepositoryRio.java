package com.xsis.xsis.repository.rio;

import com.xsis.xsis.dto.rio.TimesheetDtoRio;
import com.xsis.xsis.model.rio.TimesheetEntityRio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimesheetRepositoryRio extends JpaRepository<TimesheetEntityRio, Long>
{
    @Query(nativeQuery = true)
    List<TimesheetDtoRio> getPlacementId(Long placementId);

    @Query(nativeQuery = true)
    List<TimesheetDtoRio> searchTimesheetDate(double stYear, double stMonth);

    @Query(nativeQuery = true)
    List<TimesheetDtoRio> searchTimesheetDateByPlacementId(Long placementId, double stYear, double stMonth);
}
