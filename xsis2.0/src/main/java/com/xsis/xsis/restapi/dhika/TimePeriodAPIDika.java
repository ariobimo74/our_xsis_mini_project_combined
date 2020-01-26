package com.xsis.xsis.restapi.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.TimePeriodDika;
import com.xsis.xsis.services.dhika.TimePeriodServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * TimePeriodAPI
 */
@RestController
@RequestMapping(path = "api/time", produces = "application/json")
@CrossOrigin(origins = "*")
public class TimePeriodAPIDika {

    @Autowired
    private TimePeriodServicesDika timePeriodServices;

    @GetMapping
    public List<TimePeriodDika> findAll() {
        return timePeriodServices.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TimePeriodDika> getId(@PathVariable(value = "id") Long id) {
        return timePeriodServices.getById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TimePeriodDika addTimePeriod(@RequestBody TimePeriodDika timePeriod) {
        return timePeriodServices.save(timePeriod);
    }

    @PutMapping(path = "/{id}")
    public TimePeriodDika editTimePeriod(@RequestBody TimePeriodDika timePeriod) {
        return timePeriodServices.update(timePeriod);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TimePeriodDika deleteTP(@PathVariable("id") Long id) {
        return timePeriodServices.delete(id);
    }

}