package com.xsis.xsis.restapi.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.TimesheetPlaDtoAlfia;
import com.xsis.xsis.model.fia.TimesheetAlfia;
import com.xsis.xsis.services.fia.TimesheetServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/alfia/timesheet")
public class TimesheetAPIAlfia {

    @Autowired
    private TimesheetServiceAlfia timesheetService;

    @GetMapping
    public List<TimesheetAlfia> getAllTimesheet() {
        return timesheetService.getAll();
    }

    @GetMapping("getbyid/{id}")
    public TimesheetAlfia getById(@PathVariable(value = "id") Long id) {
        return timesheetService.getById(id);
    }

    @GetMapping("/{id}")
    public TimesheetPlaDtoAlfia findByIdTS(@PathVariable(value = "id") Long id) {
        return timesheetService.findByIdTS(id);
    }

    @GetMapping("/ts-join")
    public ResponseEntity<?> findJoinTimesheet() {
        return new ResponseEntity<>(timesheetService.joinTimesheet(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<TimesheetPlaDtoAlfia> searchTimesheet(@RequestParam(name = "yearmonth") String timesheetDate) {
        return timesheetService.searchTimesheet(timesheetDate);
    }

    @DeleteMapping("/{id}")
    public TimesheetAlfia tolakTs(@PathVariable(value = "id") Long id) {
        return timesheetService.tolakTs(id);
    }

    @DeleteMapping("/approved/{id}")
    public TimesheetAlfia setujui(@PathVariable(value = "id") Long id) {
        return timesheetService.setujui(id);
    }

}