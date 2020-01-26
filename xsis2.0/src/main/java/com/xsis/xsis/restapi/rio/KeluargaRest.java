package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.KeluargaEntityRio;
import com.xsis.xsis.services.rio.KeluargaServiceRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "rest/keluarga")
public class KeluargaRest {
    @Autowired
    private KeluargaServiceRio keluargaService;

    @GetMapping
    public Iterable<KeluargaEntityRio> findAll() {
        return keluargaService.getkeluargaEntity();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> keluargaById(@PathVariable("id") Long id) {
        Optional<KeluargaEntityRio> keluargaEntityOptional = keluargaService.findKeluargaById(id);
        if (keluargaEntityOptional.isPresent()) {
            return new ResponseEntity<>(keluargaEntityOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public KeluargaEntityRio postKeluarga(@RequestBody KeluargaEntityRio keluargaEntity) {
        KeluargaEntityRio keluarga = new KeluargaEntityRio();
        keluarga.setBiodataId(keluargaEntity.getBiodataId());
        return keluargaService.saveKeluarga(keluargaEntity);
    }

    @PutMapping
    public KeluargaEntityRio putKeluarga(@RequestBody KeluargaEntityRio keluargaEntity) {
        KeluargaEntityRio keluarga = new KeluargaEntityRio();
        keluarga.setId(keluargaEntity.getId());
        keluarga.setBiodataId(keluargaEntity.getBiodataId());
        keluarga.setFamilyTreeTypeId(keluargaEntity.getFamilyTreeTypeId());
        keluarga.setFamilyRelationId(keluargaEntity.getFamilyRelationId());
        keluarga.setName(keluargaEntity.getName());
        keluarga.setGender(keluargaEntity.getGender());
        keluarga.setDob(keluargaEntity.getDob());
        keluarga.setEducationLevelId(keluargaEntity.getEducationLevelId());
        keluarga.setJob(keluargaEntity.getJob());
        keluarga.setNotes(keluargaEntity.getNotes());
        keluarga.setModifiedBy(keluargaEntity.getModifiedBy());
        keluarga.setModifiedOn(keluargaEntity.getModifiedOn());
        return keluargaService.updateKeluarga(keluarga);
    }

    @PatchMapping
    public KeluargaEntityRio patchKeluarga(@RequestBody KeluargaEntityRio keluargaEntity) {
        return keluargaService.saveKeluarga(keluargaEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public KeluargaEntityRio deleteKeluarga(@PathVariable("id") Long id) {
        return keluargaService.hideKeluarga(id);
    }

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") int biodataId) {
        return new ResponseEntity<>(keluargaService.getBioId(biodataId), HttpStatus.OK);
    }
}
