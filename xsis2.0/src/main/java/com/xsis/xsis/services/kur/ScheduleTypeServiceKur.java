package com.xsis.xsis.services.kur;

import java.util.List;

import com.xsis.xsis.model.kur.ScheduleTypeKur;

/**
 * ScheduleTypeService
 */

public interface ScheduleTypeServiceKur {
    List<ScheduleTypeKur> getScheduleType();

    List<ScheduleTypeKur> getScheduleTypeId(Long id);

    ScheduleTypeKur getById(Long id);

}