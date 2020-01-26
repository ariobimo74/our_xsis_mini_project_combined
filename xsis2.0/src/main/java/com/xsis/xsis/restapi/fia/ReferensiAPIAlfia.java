package com.xsis.xsis.restapi.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.ReferensiDtoAlfia;
import com.xsis.xsis.model.fia.ReferensiAlfia;
import com.xsis.xsis.services.fia.ReferensiServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ReferensiAPI
 */
@RestController
@RequestMapping("api/alfia/referensi")
public class ReferensiAPIAlfia {

    @Autowired
    private ReferensiServiceAlfia referensiService;

    @GetMapping
    public List<ReferensiAlfia> getAllRefe() {
        return referensiService.getAll();
    }

    @GetMapping("/{id}")
    public ReferensiAlfia getRefById(@PathVariable(value = "id") Long id) {
        return referensiService.getById(id);
    }

    @PostMapping
    public ReferensiDtoAlfia saveRef(@RequestBody ReferensiDtoAlfia referensiDto) {
        ReferensiAlfia ref = new ReferensiAlfia();
        ref.setBiodataId(referensiDto.getBiodataId());
        ref.setName(referensiDto.getName());
        ref.setPosition(referensiDto.getPosition());
        ref.setAddressPhone(referensiDto.getAddressPhone());
        ref.setRelation(referensiDto.getRelation());
        referensiService.save(ref);
        return referensiDto;
    }

    @PutMapping
    public ReferensiDtoAlfia updateRef(@RequestBody ReferensiDtoAlfia referensiDto) {
        ReferensiAlfia ref = new ReferensiAlfia();
        ref.setId(referensiDto.getId());
        ref.setBiodataId(referensiDto.getBiodataId());
        ref.setName(referensiDto.getName());
        ref.setPosition(referensiDto.getPosition());
        ref.setAddressPhone(referensiDto.getAddressPhone());
        ref.setRelation(referensiDto.getRelation());
        referensiService.update(ref);
        return referensiDto;
    }

    @DeleteMapping("/{id}")
    public ReferensiAlfia deleteReferensi(@PathVariable(value = "id") Long id) {
        return referensiService.delete(id);
    }

    @GetMapping("/bio/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(referensiService.getBioId(biodataId), HttpStatus.OK);
    }
}