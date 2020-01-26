package com.xsis.xsis.restapi.kur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.kur.EducationKur;
import com.xsis.xsis.services.kur.EducationServicesKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * PendidikanAPI
 */
@RestController
@RequestMapping(path = "/api/education-ku", produces = "application/json")
@CrossOrigin(origins = "*")
public class EducationAPIKur {

    @Autowired
    private EducationServicesKur educationServicesKur;

    @GetMapping
    public Iterable<EducationKur> findAllEducationVacancy() {
        List<EducationKur> education = new ArrayList<>();
        for (EducationKur educations : educationServicesKur.findAllEducation()) {
            if (!educations.getIsDelete()) {
                education.add(educations);
            }
        }
        return education;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> brandById(@PathVariable("id") Long id) {
        Optional<EducationKur> optPendidikan = educationServicesKur.getEducationById(id);
        if (optPendidikan.isPresent()) {
            return new ResponseEntity<>(optPendidikan.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public EducationKur postBrand(@RequestBody EducationKur education) {
        education.setCreatedBy(1L);
        education.setCreatedOn(new Date());
        education.setIsDelete(false);
        education.setOrders(1);
        return educationServicesKur.saveEducation(education);
    }

    @PutMapping(path = "/{id}")
    public EducationKur putEducationVacancy(@RequestBody EducationKur education) {
        EducationKur educationDetail = educationServicesKur.getEducationById(education.getId()).get();
        educationDetail.setModifiedBy(1L);
        educationDetail.setModifiedOn(new Date());
        educationDetail.setId(education.getId());
        educationDetail.setSchoolName(education.getSchoolName());
        educationDetail.setCity(education.getCity());
        educationDetail.setCountry(education.getCountry());
        educationDetail.setEducationLevelId(education.getEducationLevelId());
        educationDetail.setEntryYear(education.getEntryYear());
        educationDetail.setGraduationYear(education.getGraduationYear());
        educationDetail.setMajor(education.getMajor());
        educationDetail.setGpa(education.getGpa());
        educationDetail.setNotes(education.getNotes());
        educationDetail.setOrders(1);
        educationDetail.setJudulTa(education.getJudulTa());
        educationDetail.setDeskripsiTa(education.getDeskripsiTa());
        return educationServicesKur.saveEducation(educationDetail);
    }

    @DeleteMapping("/{id}")
    public EducationKur deleteEducationVacancy(@PathVariable(value = "id") Long id) {
        EducationKur edu = educationServicesKur.getEducationById(id).get();
        edu.setIsDelete(true);
        edu.setDeletedBy(1L);
        edu.setDeleteddOn(new Date());
        return educationServicesKur.saveEducation(edu);
    }

    // Join with Education Level
    @GetMapping("/level/{biodata_id}")
    public ResponseEntity<?> findEducationName(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(educationServicesKur.getEduName(biodataId), HttpStatus.OK);
    }

    @GetMapping("/level/{biodata_id}/{id}")
    public ResponseEntity<?> findEduNameDetail(@PathVariable("biodata_id") Long biodataId,
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(educationServicesKur.getEduNameDetail(biodataId, id), HttpStatus.OK);
    }

    @GetMapping("/last/{biodata_id}")
    public ResponseEntity<?> findLastEducation(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(educationServicesKur.getLastEducation(biodataId), HttpStatus.OK);
    }

    @GetMapping("/name-last/{biodata_id}")
    public ResponseEntity<?> findNameLastEducation(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(educationServicesKur.getNameLastEdu(biodataId), HttpStatus.OK);
    }

}