package com.xsis.xsis.restapi.kur;

import java.util.List;

import com.xsis.xsis.model.kur.EmployeeKur;
import com.xsis.xsis.services.kur.EmployeeServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * EmployeeAPI
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/employee-ku", produces = "application/json")
public class EmployeeAPIKur {

    @Autowired
    private EmployeeServiceKur employeeServiceKur;

    @GetMapping
    public List<EmployeeKur> getId() {
        return employeeServiceKur.getAllEmp();
    }

    // @GetMapping("/ero-true")
    // public List<Employee> getEroAllTrue() {
    // return employeeService.getAllTrueEro();
    // }

    @GetMapping("/bio/{id}")
    public List<EmployeeKur> getBioRoTro(@PathVariable(value = "id") Long id) {
        return employeeServiceKur.getBioRoTro(id);
    }

}