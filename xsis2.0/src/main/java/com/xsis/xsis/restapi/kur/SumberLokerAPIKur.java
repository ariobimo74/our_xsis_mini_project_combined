package com.xsis.xsis.restapi.kur;

import java.util.List;

import com.xsis.xsis.dto.kur.SumberLokerDtoKur;
import com.xsis.xsis.model.kur.SumberLokerKur;
import com.xsis.xsis.services.kur.SumberLokerServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/sumber-loker-ku", produces = "application/json")
@CrossOrigin(origins = "*")
public class SumberLokerAPIKur {

    @Autowired
    private SumberLokerServiceKur sumberLokerServiceKur;

    @GetMapping
    public List<SumberLokerKur> getId() {
        return sumberLokerServiceKur.getAll();
    }

    @GetMapping("/{id}")
    public SumberLokerKur getPengalamanId(@PathVariable(value = "id") Long id) {
        return sumberLokerServiceKur.getById(id);
    }

    @GetMapping("/bio/{biodata_id}")
    public ResponseEntity<?> findCategoryBrand(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(sumberLokerServiceKur.getBioId(biodataId), HttpStatus.OK);
    }

    @PostMapping
    public SumberLokerDtoKur simpanPengalaman(@RequestBody SumberLokerDtoKur kerjaDto) {
        SumberLokerKur pengalaman = new SumberLokerKur();
        pengalaman.setBiodataId(kerjaDto.getBiodataId());
        pengalaman.setVacancySource(kerjaDto.getVacancySource());
        pengalaman.setCandidateType(kerjaDto.getCandidateType());
        pengalaman.setEventName(kerjaDto.getEventName());
        pengalaman.setCareerCenterName(kerjaDto.getCareerCenterName());
        pengalaman.setReferrerName(kerjaDto.getReferrerName());
        pengalaman.setReferrerPhone(kerjaDto.getReferrerPhone());
        pengalaman.setReferrerEmail(kerjaDto.getReferrerEmail());
        pengalaman.setOtherSource(kerjaDto.getOtherSource());
        pengalaman.setLastIncome(kerjaDto.getLastIncome());
        pengalaman.setApplyDate(kerjaDto.getApplyDate());
        sumberLokerServiceKur.save(pengalaman);

        return kerjaDto;
    }

    @PutMapping
    public SumberLokerDtoKur editPengalaman(@RequestBody SumberLokerDtoKur kerjaDto) {
        SumberLokerKur pengalaman = new SumberLokerKur();
        pengalaman.setId(kerjaDto.getId());
        pengalaman.setBiodataId(kerjaDto.getBiodataId());
        pengalaman.setVacancySource(kerjaDto.getVacancySource());
        pengalaman.setCandidateType(kerjaDto.getCandidateType());
        pengalaman.setEventName(kerjaDto.getEventName());
        pengalaman.setCareerCenterName(kerjaDto.getCareerCenterName());
        pengalaman.setReferrerName(kerjaDto.getReferrerName());
        pengalaman.setReferrerPhone(kerjaDto.getReferrerPhone());
        pengalaman.setReferrerEmail(kerjaDto.getReferrerEmail());
        pengalaman.setOtherSource(kerjaDto.getOtherSource());
        pengalaman.setLastIncome(kerjaDto.getLastIncome());
        pengalaman.setApplyDate(kerjaDto.getApplyDate());
        sumberLokerServiceKur.update(pengalaman);
        return kerjaDto;
    }

}