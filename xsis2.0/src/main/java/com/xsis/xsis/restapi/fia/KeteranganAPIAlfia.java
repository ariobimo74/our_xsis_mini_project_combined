package com.xsis.xsis.restapi.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.KeteranganDtoAlfia;
import com.xsis.xsis.model.fia.KeteranganAlfia;
import com.xsis.xsis.services.fia.KeteranganServiceAlfia;

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
 * KeteranganAPI
 */
@RestController
@RequestMapping("api/alfia/keterangantambahan")
public class KeteranganAPIAlfia {

    @Autowired
    private KeteranganServiceAlfia keteranganService;

    @GetMapping
    public List<KeteranganAlfia> getAllKet() {
        return keteranganService.getAll();
    }

    @GetMapping("/{id}")
    public KeteranganAlfia getKetById(@PathVariable(value = "id") Long id) {
        return keteranganService.getById(id);
    }

    @PostMapping
    public KeteranganDtoAlfia saveKet(@RequestBody KeteranganDtoAlfia keteranganDto) {
        KeteranganAlfia ket = new KeteranganAlfia();
        ket.setBiodataId(keteranganDto.getBiodataId());
        ket.setEmergencyContactName(keteranganDto.getEmergencyContactName());
        ket.setEmergencyContactPhone(keteranganDto.getEmergencyContactPhone());
        ket.setExpectedSalary(keteranganDto.getExpectedSalary());
        ket.setIsNegotiable(keteranganDto.getIsNegotiable());
        ket.setStartWorking(keteranganDto.getStartWorking());
        ket.setIsReadyToOutoftown(keteranganDto.getIsReadyToOutoftown());
        ket.setIsApplyOtherPlace(keteranganDto.getIsApplyOtherPlace());
        ket.setApplyPlace(keteranganDto.getApplyPlace());
        ket.setSelectionPhase(keteranganDto.getSelectionPhase());
        ket.setIsEverBadlySick(keteranganDto.getIsEverBadlySick());
        ket.setDiseaseName(keteranganDto.getDiseaseName());
        ket.setDiseaseTime(keteranganDto.getDiseaseTime());
        ket.setIsEverPsychotest(keteranganDto.getIsEverPsychotest());
        ket.setPsychotestNeeds(keteranganDto.getPsychotestNeeds());
        ket.setPsychotestTime(keteranganDto.getPsychotestTime());
        ket.setRequirementesRequired(keteranganDto.getRequirementesRequired());
        ket.setOtherNotes(keteranganDto.getOtherNotes());
        keteranganService.save(ket);
        return keteranganDto;
    }

    @PutMapping
    public KeteranganDtoAlfia updateKet(@RequestBody KeteranganDtoAlfia keteranganDto) {
        KeteranganAlfia ket = new KeteranganAlfia();
        ket.setId(keteranganDto.getId());
        ket.setBiodataId(keteranganDto.getBiodataId());
        ket.setEmergencyContactName(keteranganDto.getEmergencyContactName());
        ket.setEmergencyContactPhone(keteranganDto.getEmergencyContactPhone());
        ket.setExpectedSalary(keteranganDto.getExpectedSalary());
        ket.setIsNegotiable(keteranganDto.getIsNegotiable());
        ket.setStartWorking(keteranganDto.getStartWorking());
        ket.setIsReadyToOutoftown(keteranganDto.getIsReadyToOutoftown());
        ket.setIsApplyOtherPlace(keteranganDto.getIsApplyOtherPlace());
        ket.setApplyPlace(keteranganDto.getApplyPlace());
        ket.setSelectionPhase(keteranganDto.getSelectionPhase());
        ket.setIsEverBadlySick(keteranganDto.getIsEverBadlySick());
        ket.setDiseaseName(keteranganDto.getDiseaseName());
        ket.setDiseaseTime(keteranganDto.getDiseaseTime());
        ket.setIsEverPsychotest(keteranganDto.getIsEverPsychotest());
        ket.setPsychotestNeeds(keteranganDto.getPsychotestNeeds());
        ket.setPsychotestTime(keteranganDto.getPsychotestTime());
        ket.setRequirementesRequired(keteranganDto.getRequirementesRequired());
        ket.setOtherNotes(keteranganDto.getOtherNotes());
        keteranganService.update(ket);
        return keteranganDto;
    }

    @DeleteMapping("/{id}")
    public KeteranganAlfia deleteKeterangan(@PathVariable(value = "id") Long id) {
        return keteranganService.delete(id);
    }

    @GetMapping("/bio/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(keteranganService.getBioId(biodataId), HttpStatus.OK);
    }
}