package com.xsis.xsis.restapi.fathan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.BiodataFathan;
import com.xsis.xsis.services.fathan.BiodataServicesFathan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * BiodataAPI
 */
@RestController
@RequestMapping(path = "api/biodata-fathan", produces = "application/json")
@CrossOrigin(origins = "*")
public class BiodataAPIFathan {

    @Autowired
    private BiodataServicesFathan biodataServices;

    @GetMapping
    public Iterable<BiodataFathan> findAllBiodata() {
        List<BiodataFathan> biodata = new ArrayList<>();
        for (BiodataFathan biodatas : biodataServices.getBiodata()) {
            if (!biodatas.getIsDelete()) {
                biodata.add(biodatas);
            }
        }
        return biodata;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> biodataById(@PathVariable("id") Long id) {
        Optional<BiodataFathan> optBiodata = biodataServices.getBiodataById(id);
        if (optBiodata.isPresent()) {
            return new ResponseEntity<>(optBiodata.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/{id}")
    public BiodataFathan editbio(@RequestBody BiodataFathan biodata) {
        return biodataServices.edit(biodata);
    }

}