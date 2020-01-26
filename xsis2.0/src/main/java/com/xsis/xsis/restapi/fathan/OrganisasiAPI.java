package com.xsis.xsis.restapi.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.Organisasi;
import com.xsis.xsis.services.fathan.OrganisasiService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
 * OrganisasiAPI
 */
@RestController
@RequestMapping("api/organisasi")
@CrossOrigin(origins = "*")
public class OrganisasiAPI {
    @Autowired
    private OrganisasiService organisasiService;

    @GetMapping
    public List<Organisasi> getAll() {
        return organisasiService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Organisasi> getId(@PathVariable(value = "id") Long id) {
        return organisasiService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Organisasi editOrg(@RequestBody Organisasi organisasi) {
        return organisasiService.edit(organisasi);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Organisasi addOrg(@RequestBody Organisasi organisasi) {
        return organisasiService.save(organisasi);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Organisasi deleteOrg(@PathVariable("id") Long id) {
        return organisasiService.delete(id);
    }

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(organisasiService.getBioId(biodataId), HttpStatus.OK);
    }
    
}