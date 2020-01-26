package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.CatatanEntityRio;
import com.xsis.xsis.services.rio.CatatanServiceRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "rest/catatan")
@CrossOrigin("*")
public class CatatanRest
{
    @Autowired
    private CatatanServiceRio catatanService;

    @GetMapping
    public Iterable<CatatanEntityRio> findAll()
    {
        return catatanService.getCatatanEntity();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> catatanById(@PathVariable("id") Long id)
    {
        Optional<CatatanEntityRio> optionalCatatanEntity = catatanService.findCatatanById(id);
        if (optionalCatatanEntity.isPresent()) {
            return new ResponseEntity<>(optionalCatatanEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CatatanEntityRio postCatatan(@RequestBody CatatanEntityRio catatanEntity)
    {
        CatatanEntityRio catatan = new CatatanEntityRio();
        catatan.setBiodataId(catatanEntity.getBiodataId());
        return catatanService.saveCatatan(catatanEntity);
    }

    @PutMapping
    public CatatanEntityRio putCatatan(@RequestBody CatatanEntityRio catatanEntity)
    {
        CatatanEntityRio catatan = new CatatanEntityRio();
        catatan.setId(catatanEntity.getId());
        catatan.setTitle(catatanEntity.getTitle());
        catatan.setNoteTypeId(catatanEntity.getNoteTypeId());
        catatan.setNotes(catatanEntity.getNotes());
        catatanService.updateCatatan(catatan);
        return catatanEntity;
    }

    @PatchMapping
    public CatatanEntityRio patchCatatan(@RequestBody CatatanEntityRio catatanEntity)
    {
        return catatanService.saveCatatan(catatanEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CatatanEntityRio deleteCatatan(@PathVariable("id") Long id)
    {
        return catatanService.hideCatatan(id);
    }

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") int biodataId)
    {
        return new ResponseEntity<>(catatanService.getBioId(biodataId), HttpStatus.OK);
    }
}
