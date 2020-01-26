package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.KeahlianEntityRio;
import com.xsis.xsis.services.rio.KeahlianServiceRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "rest/keahlian")
public class KeahlianRest {
    @Autowired
    private KeahlianServiceRio keahlianService;

    @GetMapping
    public Iterable<KeahlianEntityRio> findAll() {
        return keahlianService.getKeahlianEntity();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> keahlianById(@PathVariable("id") Long id) {
        Optional<KeahlianEntityRio> optionalKeahlianEntity = keahlianService.findKeahlianById(id);
        if (optionalKeahlianEntity.isPresent()) {
            return new ResponseEntity<>(optionalKeahlianEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public KeahlianEntityRio postKeahlian(@RequestBody KeahlianEntityRio keahlianEntity) {
        KeahlianEntityRio keahlian = new KeahlianEntityRio();
        keahlian.setBiodataId(keahlianEntity.getBiodataId());
        return keahlianService.saveKeahlian(keahlianEntity);
    }

    @PutMapping
    public KeahlianEntityRio putKeahlian(@RequestBody KeahlianEntityRio keahlianEntity) {
        KeahlianEntityRio keahlian = new KeahlianEntityRio();
        keahlian.setId(keahlianEntity.getId());
        keahlian.setSkillName(keahlianEntity.getSkillName());
        keahlian.setSkillLevelId(keahlianEntity.getSkillLevelId());
        keahlian.setNotes(keahlianEntity.getNotes());
        return keahlianService.updateKeahlian(keahlian);
    }

    @PatchMapping
    public KeahlianEntityRio patchKeahlian(@RequestBody KeahlianEntityRio keahlianEntity) {
        return keahlianService.saveKeahlian(keahlianEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public KeahlianEntityRio deleteKeahlian(@PathVariable("id") Long id) {
        return keahlianService.hideKeahlian(id);
    }

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(keahlianService.getBioId(biodataId), HttpStatus.OK);
    }
}
