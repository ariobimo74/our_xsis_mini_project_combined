package com.xsis.xsis.services.dhika;

import java.util.*;

import com.xsis.xsis.model.dhika.TimesheetDika;

import org.springframework.data.repository.query.Param;

/**
 * TimesheetService
 */
public interface TimesheetServiceDika {

    List<TimesheetDika> getAll();

    // List<Timesheet> getName();

    Optional<TimesheetDika> getById(Long id);

    TimesheetDika save(TimesheetDika timesheet);

    TimesheetDika update(TimesheetDika timesheet);

    TimesheetDika delete(Long id);

    List<TimesheetDika> getResultSearchDateTimesheet(@Param("sd") String startDate, @Param("ed") String endDate);

}