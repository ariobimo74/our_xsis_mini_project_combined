package com.xsis.xsis.restapi.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.SertifikasiDtoAlfia;
import com.xsis.xsis.model.fia.SertifikasiAlfia;
import com.xsis.xsis.services.fia.SertifikasiServiceAlfia;

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

@RestController
@RequestMapping("api/alfia/sertifikasi")
public class SertifikasiAPIAlfia {

    @Autowired
    private SertifikasiServiceAlfia sertifikasiService;

    @GetMapping
    public List<SertifikasiAlfia> getAllSertif() {
        return sertifikasiService.getAll();
    }

    @GetMapping("/{id}")
    public SertifikasiAlfia getSertifById(@PathVariable(value = "id") Long id) {
        return sertifikasiService.getById(id);
    }

    @PostMapping
    public SertifikasiDtoAlfia saveSertif(@RequestBody SertifikasiDtoAlfia sertifikasiDto) {
        SertifikasiAlfia sertif = new SertifikasiAlfia();
        sertif.setBiodataId(sertifikasiDto.getBiodataId());
        sertif.setCertificateName(sertifikasiDto.getCertificateName());
        sertif.setPublisher(sertifikasiDto.getPublisher());
        sertif.setValidStartYear(sertifikasiDto.getValidStartYear());
        sertif.setValidStartMonth(sertifikasiDto.getValidStartMonth());
        sertif.setUntilYear(sertifikasiDto.getUntilYear());
        sertif.setUntilMonth(sertifikasiDto.getUntilMonth());
        sertif.setNotes(sertifikasiDto.getNotes());
        sertifikasiService.save(sertif);
        return sertifikasiDto;
    }

    @PutMapping
    public SertifikasiDtoAlfia updateSertifikasi(@RequestBody SertifikasiDtoAlfia sertifikasiDto) {
        SertifikasiAlfia sertifikasi = new SertifikasiAlfia();
        sertifikasi.setId(sertifikasiDto.getId());
        sertifikasi.setBiodataId(sertifikasiDto.getBiodataId());
        sertifikasi.setCertificateName(sertifikasiDto.getCertificateName());
        sertifikasi.setPublisher(sertifikasiDto.getPublisher());
        sertifikasi.setValidStartYear(sertifikasiDto.getValidStartYear());
        sertifikasi.setValidStartMonth(sertifikasiDto.getValidStartMonth());
        sertifikasi.setUntilYear(sertifikasiDto.getUntilYear());
        sertifikasi.setUntilMonth(sertifikasiDto.getUntilMonth());
        sertifikasi.setNotes(sertifikasiDto.getNotes());
        sertifikasiService.update(sertifikasi);
        return sertifikasiDto;
    }

    @DeleteMapping("/{id}")
    public SertifikasiAlfia deleteSertifikasi(@PathVariable(value = "id") Long id) {
        return sertifikasiService.delete(id);
    }

    @GetMapping("/bio/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(sertifikasiService.getBioId(biodataId), HttpStatus.OK);
    }
}