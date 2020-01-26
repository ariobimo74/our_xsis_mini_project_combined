package com.xsis.xsis.restapi.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.dhika.TimesheetDtoDika;
import com.xsis.xsis.model.dhika.TimesheetDika;
import com.xsis.xsis.services.dhika.TimesheetServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * TimesheetAPI
 */

@RestController
@RequestMapping(path = "api/timesheet", produces = "application/json")
@CrossOrigin("*")
public class TimesheetAPIDika {

    @Autowired
    TimesheetServiceDika timesheetService;

    @GetMapping
    public List<TimesheetDika> getAll() {
        return timesheetService.getAll();
    }

    @GetMapping("/searchDate")
    public List<TimesheetDika> searchDate(@RequestParam(name = "sd") String startDate,
            @RequestParam(name = "ed") String endDate) {
        return timesheetService.getResultSearchDateTimesheet(startDate, endDate);
    }

    // @GetMapping("/getclient")
    // public List<Timesheet> getClientName() {
    // return timesheetService.getName();
    // }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        Optional<TimesheetDika> optReg = timesheetService.getById(id);
        if (optReg.isPresent()) {
            return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public TimesheetDika PostTimesheet(@RequestBody TimesheetDtoDika timesheetdto) {
        TimesheetDika tms = new TimesheetDika();
        tms.setStatus(timesheetdto.getStatus());
        tms.setPlacementId(timesheetdto.getPlacementId());
        tms.setTimesheetDate(timesheetdto.getTimesheetDate());
        tms.setStart(timesheetdto.getStart());
        tms.setEndTime(timesheetdto.getEndTime());
        tms.setOvertime(timesheetdto.getOvertime());
        tms.setStartOt(timesheetdto.getStartOt());
        tms.setEndOt(timesheetdto.getEndOt());
        tms.setActivity(timesheetdto.getActivity());
        tms.setUserApproval(timesheetdto.getUserApproval());
        tms.setSubmittedOn(timesheetdto.getSubmittedOn());
        tms.setApprovedOn(timesheetdto.getApprovedOn());
        tms.setEroStatus(timesheetdto.getEroStatus());
        tms.setSentOn(timesheetdto.getSentOn());
        tms.setCollectedOn(timesheetdto.getCollectedOn());
        return timesheetService.save(tms);
    }

    @PutMapping
    public TimesheetDika putMethodName(@RequestBody TimesheetDtoDika timesheetdto) {
        TimesheetDika tms = new TimesheetDika();
        tms.setId(timesheetdto.getId());
        tms.setStatus(timesheetdto.getStatus());
        tms.setPlacementId(timesheetdto.getPlacementId());
        tms.setTimesheetDate(timesheetdto.getTimesheetDate());
        tms.setStart(timesheetdto.getStart());
        tms.setEndTime(timesheetdto.getEndTime());
        tms.setOvertime(timesheetdto.getOvertime());
        tms.setStartOt(timesheetdto.getStartOt());
        tms.setEndOt(timesheetdto.getEndOt());
        tms.setActivity(timesheetdto.getActivity());
        tms.setUserApproval(timesheetdto.getUserApproval());
        tms.setSubmittedOn(timesheetdto.getSubmittedOn());
        tms.setApprovedOn(timesheetdto.getApprovedOn());
        tms.setEroStatus(timesheetdto.getEroStatus());
        tms.setSentOn(timesheetdto.getSentOn());
        tms.setCollectedOn(timesheetdto.getCollectedOn());

        return timesheetService.update(tms);
    }

    @DeleteMapping(path = "/{id}")
    public TimesheetDika deleteTimesheet(@PathVariable("id") Long id) {
        return timesheetService.delete(id);
    }

}