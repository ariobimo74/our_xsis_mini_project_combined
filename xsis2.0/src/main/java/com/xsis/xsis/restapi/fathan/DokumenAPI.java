package com.xsis.xsis.restapi.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.Dokumen;
import com.xsis.xsis.services.fathan.DokumenService;

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
 * DokumenAPI
 */
@RestController
@RequestMapping(path = "api/dokumen" , produces = "application/json")
@CrossOrigin(origins = "*")
public class DokumenAPI {
    @Autowired
    private DokumenService dokumenService;

    @GetMapping
    public List<Dokumen> getAll() {
        return dokumenService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Dokumen> getId(@PathVariable(value = "id") Long id) {
        return dokumenService.getById(id);
    }

    @PostMapping("/uploadFoto")
    @ResponseStatus(HttpStatus.CREATED)
    public Dokumen addFoto(@RequestBody Dokumen dokumen){
        return dokumenService.saveFoto(dokumen);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Dokumen addDok(@RequestBody Dokumen dokumen) {
        return dokumenService.saveFile(dokumen);
    }

    @PutMapping(path = "/{id}")
    public Dokumen editDok(@RequestBody Dokumen dokumen) {
        return dokumenService.edit(dokumen);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Dokumen deleteDok(@PathVariable("id") Long id) {
        return dokumenService.delete(id);
    }

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(dokumenService.getBioId(biodataId), HttpStatus.OK);
    }
}