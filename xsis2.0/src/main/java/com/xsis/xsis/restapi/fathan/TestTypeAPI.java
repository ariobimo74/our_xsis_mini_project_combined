package com.xsis.xsis.restapi.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.TestType;
import com.xsis.xsis.services.fathan.TestTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * TestTypeAPI
 */
@RestController
@RequestMapping("api/type")
public class TestTypeAPI {
    @Autowired
    private TestTypeService testTypeService;

    @GetMapping("/")
    public List<TestType> getAll() {
        return testTypeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TestType> getId(@PathVariable(value = "id") Long id){
        return testTypeService.getById(id);
    }

    @PostMapping(consumes ="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TestType addTestType(@RequestBody TestType testType) {        
        return testTypeService.save(testType);
    }

    @PutMapping(path = "/{id}")
    public TestType ediTestType(@RequestBody TestType testType){
        return testTypeService.edit(testType);
    }
    
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TestType deleTestType(@PathVariable("id") Long id){
        return testTypeService.delete(id);
    }

}