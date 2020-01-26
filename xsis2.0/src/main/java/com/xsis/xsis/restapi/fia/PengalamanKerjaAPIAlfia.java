package com.xsis.xsis.restapi.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.PengalamanKerjaDtoAlfia;
import com.xsis.xsis.model.fia.PengalamanKerjaAlfia;
import com.xsis.xsis.services.fia.PengalamanKerjaServiceAlfia;

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
@RequestMapping(path = "/api/alfia/pengalamankerja", produces = "application/json")
@CrossOrigin(origins = "*")
public class PengalamanKerjaAPIAlfia {

    @Autowired
    private PengalamanKerjaServiceAlfia pengalamanKerjaService;

    @GetMapping
    public List<PengalamanKerjaAlfia> getId() {
        return pengalamanKerjaService.getAll();
    }

    @GetMapping("/{id}")
    public PengalamanKerjaAlfia getPengalamanId(@PathVariable(value = "id") Long id) {
        return pengalamanKerjaService.getById(id);
    }

    @GetMapping("/bio/{biodata_id}")
    public ResponseEntity<?> findCategoryBrand(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(pengalamanKerjaService.getBioId(biodataId), HttpStatus.OK);
    }

    @PostMapping
    public PengalamanKerjaDtoAlfia simpanPengalaman(@RequestBody PengalamanKerjaDtoAlfia kerjaDto) {
        PengalamanKerjaAlfia pengalaman = new PengalamanKerjaAlfia();
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
        pengalamanKerjaService.save(pengalaman);
        return kerjaDto;
    }

    @PutMapping
    public PengalamanKerjaDtoAlfia editPengalaman(@RequestBody PengalamanKerjaDtoAlfia kerjaDto) {
        PengalamanKerjaAlfia pengalaman = new PengalamanKerjaAlfia();
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
        pengalamanKerjaService.update(pengalaman);
        return kerjaDto;
    }

    @DeleteMapping("/{id}")
    public PengalamanKerjaAlfia deletePengalaman(@PathVariable(value = "id") Long id) {
        return pengalamanKerjaService.delete(id);
    }

}