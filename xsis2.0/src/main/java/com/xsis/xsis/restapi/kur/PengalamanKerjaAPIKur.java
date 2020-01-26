package com.xsis.xsis.restapi.kur;

import java.util.List;

import com.xsis.xsis.dto.kur.PengalamanKerjaDtoKur;
import com.xsis.xsis.model.kur.entity.PengalamanKerjaKur;
import com.xsis.xsis.services.kur.PengalamanKerjaServiceKur;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/pengalamankerja-ku", produces = "application/json")
@CrossOrigin(origins = "*")
public class PengalamanKerjaAPIKur {

    @Autowired
    private PengalamanKerjaServiceKur pengalamanKerjaServiceKur;

    @GetMapping
    public List<PengalamanKerjaKur> getId() {
        return pengalamanKerjaServiceKur.getAll();
    }

    @GetMapping("/{id}")
    public PengalamanKerjaKur getPengalamanId(@PathVariable(value = "id") Long id) {
        return pengalamanKerjaServiceKur.getById(id);
    }

    @GetMapping("/bio/{biodata_id}")
    public ResponseEntity<?> findCategoryBrand(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(pengalamanKerjaServiceKur.getBioId(biodataId), HttpStatus.OK);
    }

    @PostMapping
    public PengalamanKerjaDtoKur simpanPengalaman(@RequestBody PengalamanKerjaDtoKur kerjaDto) {
        PengalamanKerjaKur pengalaman = new PengalamanKerjaKur();
        pengalaman.setBiodataId(kerjaDto.getBiodataId());
        pengalaman.setCompanyName(kerjaDto.getCompanyName());
        pengalaman.setCity(kerjaDto.getCity());
        pengalaman.setCountry(kerjaDto.getCountry());
        pengalaman.setJoinYear(kerjaDto.getJoinYear());
        pengalaman.setJoinMonth(kerjaDto.getJoinMonth());
        pengalaman.setResignYear(kerjaDto.getResignYear());
        pengalaman.setResignMonth(kerjaDto.getResignMonth());
        pengalaman.setLastPosition(kerjaDto.getLastPosition());
        pengalaman.setIncome(kerjaDto.getIncome());
        pengalaman.setIsItRelated(kerjaDto.isIsItRelated());
        pengalaman.setAboutJob(kerjaDto.getAboutJob());
        pengalaman.setExitReason(kerjaDto.getExitReason());
        pengalaman.setAboutJob(kerjaDto.getAboutJob());
        pengalaman.setNotes(kerjaDto.getNotes());
        pengalamanKerjaServiceKur.save(pengalaman);
        return kerjaDto;
    }

    @PutMapping
    public PengalamanKerjaDtoKur editPengalaman(@RequestBody PengalamanKerjaDtoKur kerjaDto) {
        PengalamanKerjaKur pengalaman = new PengalamanKerjaKur();
        pengalaman.setId(kerjaDto.getId());
        pengalaman.setBiodataId(kerjaDto.getBiodataId());
        pengalaman.setCompanyName(kerjaDto.getCompanyName());
        pengalaman.setCity(kerjaDto.getCity());
        pengalaman.setCountry(kerjaDto.getCountry());
        pengalaman.setJoinYear(kerjaDto.getJoinYear());
        pengalaman.setJoinMonth(kerjaDto.getJoinMonth());
        pengalaman.setResignYear(kerjaDto.getResignYear());
        pengalaman.setResignMonth(kerjaDto.getResignMonth());
        pengalaman.setLastPosition(kerjaDto.getLastPosition());
        pengalaman.setIncome(kerjaDto.getIncome());
        pengalaman.setIsItRelated(kerjaDto.isIsItRelated());
        pengalaman.setAboutJob(kerjaDto.getAboutJob());
        pengalaman.setExitReason(kerjaDto.getExitReason());
        pengalaman.setAboutJob(kerjaDto.getAboutJob());
        pengalaman.setNotes(kerjaDto.getNotes());
        pengalamanKerjaServiceKur.update(pengalaman);
        return kerjaDto;
    }

    @DeleteMapping("/{id}")
    public PengalamanKerjaKur deletePengalaman(@PathVariable(value = "id") Long id) {
        return pengalamanKerjaServiceKur.delete(id);
    }

}