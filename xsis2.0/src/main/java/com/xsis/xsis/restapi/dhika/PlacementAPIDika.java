package com.xsis.xsis.restapi.dhika;

import java.util.*;

import com.xsis.xsis.model.dhika.PlacementDika;
import com.xsis.xsis.services.dhika.PlacementServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PlacementAPI
 */
@RestController
@RequestMapping(path = "api/placement", produces = "application/json")
@CrossOrigin("*")
public class PlacementAPIDika {

    @Autowired
    PlacementServiceDika placementService;

    @GetMapping
    public List<PlacementDika> getAll() {
        return placementService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        Optional<PlacementDika> optReg = placementService.getById(id);
        if (optReg.isPresent()) {
            return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}