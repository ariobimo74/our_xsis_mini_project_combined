package com.xsis.xsis.services.kur.Implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xsis.xsis.dto.kur.SumberLokerBioIdDtoKur;
import com.xsis.xsis.model.kur.SumberLokerKur;
import com.xsis.xsis.repository.kur.SumberLokerRepositoryKur;
import com.xsis.xsis.services.kur.SumberLokerServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SumberLokerServiceImplKur implements SumberLokerServiceKur {

    @Autowired
    private SumberLokerRepositoryKur sumberLokerRepository;

    @Override
    public SumberLokerKur getById(Long id) {
        return sumberLokerRepository.findById(id).get();
    }

    @Override
    public List<SumberLokerKur> getAll() {
        List<SumberLokerKur> pengKerja = new ArrayList<>();
        for (SumberLokerKur pengKerjas : sumberLokerRepository.findAll()) {
            if (!pengKerjas.getIsDelete()) {
                pengKerja.add(pengKerjas);
            }
        }
        return pengKerja;
    }

    @Override
    public SumberLokerKur save(SumberLokerKur sumberLoker) {
        sumberLoker.setCreatedBy(1L);
        sumberLoker.setCreatedOn(new Date());
        return sumberLokerRepository.save(sumberLoker);
    }

    @Override
    public SumberLokerKur update(SumberLokerKur sumberLoker) {
        SumberLokerKur pengalaman = sumberLokerRepository.findById(sumberLoker.getId()).get();

        // common entity
        pengalaman.setModifiedBy(1L);
        pengalaman.setModifiedOn(new Date());

        // normal Entitys
        pengalaman.setBiodataId(sumberLoker.getBiodataId());
        pengalaman.setVacancySource(sumberLoker.getVacancySource());
        pengalaman.setCandidateType(sumberLoker.getCandidateType());
        pengalaman.setEventName(sumberLoker.getEventName());
        pengalaman.setCareerCenterName(sumberLoker.getCareerCenterName());
        pengalaman.setReferrerName(sumberLoker.getReferrerName());
        pengalaman.setReferrerPhone(sumberLoker.getReferrerPhone());
        pengalaman.setReferrerEmail(sumberLoker.getReferrerEmail());
        pengalaman.setOtherSource(sumberLoker.getOtherSource());
        pengalaman.setLastIncome(sumberLoker.getLastIncome());
        pengalaman.setApplyDate(sumberLoker.getApplyDate());
        return sumberLokerRepository.save(pengalaman);

    }

    @Override
    public List<SumberLokerBioIdDtoKur> getBioId(Long biodataId) {
        return sumberLokerRepository.getBioSumberLokerId(biodataId);
    }

}