package com.xsis.xsis.restapi.dhika;

import java.util.Optional;

import com.xsis.xsis.model.dhika.ReligionDika;
import com.xsis.xsis.services.dhika.ReligionServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ReligionAPI
 */
@RestController
@RequestMapping(path = "/api/religion", produces = "application/json")
@CrossOrigin(origins = "*")
public class ReligionAPIDika {

    @Autowired
    private ReligionServicesDika religionServices;

    @GetMapping
    public ResponseEntity<?> getReligionAll() {
        return new ResponseEntity<>(religionServices.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<ReligionDika>> getAllReligion(@RequestParam String name) {
        Iterable<ReligionDika> list = religionServices.searchByName(name);
        return new ResponseEntity<Iterable<ReligionDika>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<ReligionDika> getId(@PathVariable(value = "id") Long id) {
        return religionServices.getById(id);
    }

    @PostMapping(consumes = "application/json")
    public ReligionDika postReligion(@RequestBody ReligionDika religion) {
        return religionServices.save(religion);
    }

    @PutMapping(path = "/{id}")
    public ReligionDika editReligion(@RequestBody ReligionDika religion) {
        return religionServices.update(religion);
    }

    @DeleteMapping(path = "/{id}")
    public ReligionDika deleteReligion(@PathVariable("id") Long id) {
        return religionServices.delete(id);
    }

}