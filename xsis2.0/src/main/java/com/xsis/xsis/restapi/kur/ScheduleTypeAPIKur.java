package com.xsis.xsis.restapi.kur;

import java.util.List;

import com.xsis.xsis.model.kur.ScheduleTypeKur;
import com.xsis.xsis.services.kur.ScheduleTypeServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ScheduleTypeAPI
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/schedule-type-ku", produces = "application/json")
public class ScheduleTypeAPIKur {

    @Autowired
    private ScheduleTypeServiceKur scheduleTypeServiceKur;

    @GetMapping("/type/{id}")
    public List<ScheduleTypeKur> getBioRoTro(@PathVariable(value = "id") Long id) {
        return scheduleTypeServiceKur.getScheduleTypeId(id);
    }

    @GetMapping
    public List<ScheduleTypeKur> getAllScheduleType() {
        return scheduleTypeServiceKur.getScheduleType();
    }

}