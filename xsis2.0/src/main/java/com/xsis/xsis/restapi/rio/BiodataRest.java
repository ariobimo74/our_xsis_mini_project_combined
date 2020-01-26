package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.BiodataEntityRio;
import com.xsis.xsis.services.rio.BiodataSeviceRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "rest/biodata")
public class BiodataRest
{
    @Autowired
    private BiodataSeviceRio biodataSevice;

    @GetMapping
    public Iterable<BiodataEntityRio> findAll()
    {
        return biodataSevice.getBiodataEntity();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> biodataById(@PathVariable("id") Long id)
    {
        Optional<BiodataEntityRio> optionalBiodataEntity = biodataSevice.findBiodataById(id);
        if(optionalBiodataEntity.isPresent())
        {
            return new ResponseEntity<>(optionalBiodataEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BiodataEntityRio postBiodata(@RequestBody BiodataEntityRio biodataEntity)
    {
        BiodataEntityRio biodata = new BiodataEntityRio();
        biodata.setBiodataId(biodataEntity.getBiodataId());
        return biodataSevice.saveBiodata(biodataEntity);
    }

    @PutMapping
    public BiodataEntityRio putBiodata(@RequestBody BiodataEntityRio biodataEntity)
    {
        BiodataEntityRio biodata = new BiodataEntityRio();
        biodata.setModifiedBy(biodataEntity.getModifiedBy());
        biodata.setModifiedOn(biodataEntity.getModifiedOn());
        biodata.setId(biodataEntity.getId());
        biodata.setBiodataId(biodataEntity.getBiodataId());
        biodata.setToken(biodataEntity.getToken());
        biodata.setExpiredToken(biodataEntity.getExpiredToken());
        biodata.setEmail(biodataEntity.getEmail());

        return biodataSevice.updateBiodata(biodataEntity);
    }

    @PatchMapping
    public BiodataEntityRio patchBiodata(@RequestBody BiodataEntityRio biodataEntity)
    {
        BiodataEntityRio biodata = new BiodataEntityRio();
        biodata.setId(biodataEntity.getId());
        biodata.setToken(biodataEntity.getToken());
        biodata.setExpiredToken(biodataEntity.getExpiredToken());
        biodata.setEmail(biodataEntity.getEmail());

        return biodataSevice.sendEmailBiodata(biodataEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BiodataEntityRio deleteBiodata(@PathVariable("id") Long id)
    {
        return biodataSevice.hideBiodata(id);
    }
}
