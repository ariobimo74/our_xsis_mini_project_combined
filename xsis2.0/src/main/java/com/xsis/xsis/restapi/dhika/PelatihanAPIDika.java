package com.xsis.xsis.restapi.dhika;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.PelatihanDika;
import com.xsis.xsis.services.dhika.PelatihanServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * PelatihanAPI
 */
@RestController
@RequestMapping(path = "/api/pelatihan", produces = "application/json")
@CrossOrigin(origins = "*")
public class PelatihanAPIDika {

    @Autowired
    private PelatihanServicesDika pelatihanServices;

    @GetMapping
    public Iterable<PelatihanDika> findAllPelatihan() {
        List<PelatihanDika> pelatihan = new ArrayList<>();
        for (PelatihanDika training : pelatihanServices.findAllPelatihan()) {
            if (!training.getIsDelete()) {
                pelatihan.add(training);
            }
        }
        return pelatihan;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> pelatihanById(@PathVariable("id") Long id) {
        Optional<PelatihanDika> optPelatihan = pelatihanServices.getPelatihanById(id);
        if (optPelatihan.isPresent()) {
            return new ResponseEntity<>(optPelatihan.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PelatihanDika postPelatihan(@RequestBody PelatihanDika pelatihan) {
        return pelatihanServices.save(pelatihan);
    }

    @PutMapping(path = "/{id}")
    public PelatihanDika editPelatihan(@RequestBody PelatihanDika pelatihan) {

        return pelatihanServices.update(pelatihan);

    }

    @DeleteMapping("/{id}")
    public PelatihanDika deletePelatihan(@PathVariable(value = "id") Long id) {
        return pelatihanServices.delete(id);
    }

    // Join dengan Time Period

    @GetMapping("/period/{biodata_id}")
    public ResponseEntity<?> findPelatihanPeriod(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(pelatihanServices.getPelatihan(biodataId), HttpStatus.OK);
    }

    @GetMapping("/period/{biodata_id}/{id}")
    public ResponseEntity<?> FindPelatihanPeriodById(@PathVariable("biodata_id") Long biodataId,
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(pelatihanServices.getPelatihanDetail(biodataId, id), HttpStatus.OK);
    }

}