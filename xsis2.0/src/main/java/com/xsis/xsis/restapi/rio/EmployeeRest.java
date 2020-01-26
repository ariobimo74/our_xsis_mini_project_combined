package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.EmployeeEntityRio;
import com.xsis.xsis.services.rio.EmployeeServiceRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "rest/employee")
public class EmployeeRest
{
    @Autowired
    private EmployeeServiceRio employeeService;

    @GetMapping
    public Iterable<EmployeeEntityRio> findAll()
    {
        return employeeService.getEmployeeEntity();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> employeeById(@PathVariable("id") Long id)
    {
        Optional<EmployeeEntityRio> optionalEmployeeEntity = employeeService.findEmployeeById(id);
        if(optionalEmployeeEntity.isPresent())
        {
            return new ResponseEntity<>(optionalEmployeeEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/biodata")
    public ResponseEntity<?> findAllEmployee()
    {
        return new ResponseEntity<>(employeeService.getAllEmployeeMapping(), HttpStatus.OK);
    }

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") int biodataId)
    {
        return new ResponseEntity<>(employeeService.getBioId(biodataId), HttpStatus.OK);
    }
}
