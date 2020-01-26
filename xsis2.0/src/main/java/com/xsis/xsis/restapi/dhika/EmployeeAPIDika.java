package com.xsis.xsis.restapi.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.EmployeeDika;
import com.xsis.xsis.services.dhika.EmployeeServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeAPI
 */
@RestController
@RequestMapping(path = "/api/employee-dika", produces = "application/json")
@CrossOrigin("*")
public class EmployeeAPIDika {

    @Autowired
    EmployeeServiceDika employeeService;

    @GetMapping
    public List<EmployeeDika> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        Optional<EmployeeDika> optReg = employeeService.getById(id);
        if (optReg.isPresent()) {
            return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/empl/{id}")
    public ResponseEntity<?> getEmployeeByBio(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getRoAndTroByBiodataId(id), HttpStatus.OK);
    }

}