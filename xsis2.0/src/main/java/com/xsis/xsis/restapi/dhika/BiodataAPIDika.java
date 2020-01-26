package com.xsis.xsis.restapi.dhika;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.BiodataDika;
import com.xsis.xsis.services.dhika.BiodataServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BiodataAPI
 */
@RestController
@RequestMapping(path = "/api/biodata-dika", produces = "application/json")
@CrossOrigin(origins = "*")
public class BiodataAPIDika {

    @Autowired
    private BiodataServicesDika biodataServices;

    @GetMapping
    public Iterable<BiodataDika> findAllBiodata() {
        List<BiodataDika> biodata = new ArrayList<>();
        for (BiodataDika biodatas : biodataServices.getBiodata()) {
            if (!biodatas.getIsDelete()) {
                biodata.add(biodatas);
            }
        }
        return biodata;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> biodataById(@PathVariable("id") Long id) {
        Optional<BiodataDika> optBiodata = biodataServices.getBiodataById(id);
        if (optBiodata.isPresent()) {
            return new ResponseEntity<>(optBiodata.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}