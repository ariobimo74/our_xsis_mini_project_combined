package com.xsis.xsis.services.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.TimesheetPlaDtoAlfia;
import com.xsis.xsis.model.fia.TimesheetAlfia;

import org.springframework.data.repository.query.Param;

/**
 * TimesheetService
 */
public interface TimesheetServiceAlfia {

    List<TimesheetAlfia> getAll();

    TimesheetAlfia getById(Long id);

    TimesheetAlfia tolakTs(Long id);

    TimesheetAlfia setujui(Long id);

    TimesheetPlaDtoAlfia findByIdTS(@Param("idsearch") Long id);

    List<TimesheetPlaDtoAlfia> joinTimesheet();

    List<TimesheetPlaDtoAlfia> searchTimesheet(@Param("yearmonth") String timesheetDate);
}