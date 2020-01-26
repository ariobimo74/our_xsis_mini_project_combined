package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.dto.rio.TimesheetDtoRio;
import com.xsis.xsis.model.rio.TimesheetEntityRio;
import com.xsis.xsis.services.rio.TimesheetServiceRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "rest/timesheet")
public class TimesheetRest
{
    @Autowired
    private TimesheetServiceRio timesheetService;

    @GetMapping
    public Iterable<TimesheetEntityRio> findAll()
    {
        return timesheetService.getTimesheetEntity();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> timesheetById(@PathVariable("id") Long id)
    {
        Optional<TimesheetEntityRio> optionalTimesheetEntity = timesheetService.findTimesheetById(id);
        if(optionalTimesheetEntity.isPresent())
        {
            return new ResponseEntity<>(optionalTimesheetEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/placement/{placement_id}")
    public ResponseEntity<?> findPlacementId(@PathVariable("placement_id") Long placementId)
    {
        return new ResponseEntity<>(timesheetService.getPlacementId(placementId), HttpStatus.OK);
    }

    @GetMapping("/searchdate/placementid/{placement_id}/year/{st_year}/month/{st_month}")
    public List<TimesheetDtoRio> searchTimesheetDateByPlacementId(@PathVariable("placement_id") Long placementId, @PathVariable("st_year") double stYear, @PathVariable("st_month") double stMonth)
    {
        return timesheetService.searchTimesheetDateByPlacementId(placementId, stYear, stMonth);
    }

    @GetMapping("/searchdate/{st_year}/{st_month}")
    public List<TimesheetDtoRio> searchTimesheetDate(@PathVariable("st_year") double stYear, @PathVariable("st_month") double stMonth)
    {
        return timesheetService.searchTimesheetDate(stYear, stMonth);
    }

    @PutMapping
    public TimesheetEntityRio putTimesheet(@RequestBody TimesheetEntityRio timesheetEntity)
    {
        TimesheetEntityRio timesheet = new TimesheetEntityRio();
        timesheet.setId(timesheetEntity.getId());
        timesheet.setModifiedOn(timesheetEntity.getModifiedOn());
        timesheet.setModifiedBy(timesheetEntity.getModifiedBy());
        timesheet.setSentOn(timesheetEntity.getSentOn());
        timesheet.setEroStatus(timesheetEntity.getEroStatus());

        return timesheetService.updateTimesheet(timesheet);
    }

    @PatchMapping
    public String patchTimesheet()
    {
        return timesheetService.sendTimesheet();
    }
}
