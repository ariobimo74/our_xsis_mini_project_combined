package com.xsis.xsis.services.dhika.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.xsis.xsis.dto.dhika.pelatihanDtoDika;
import com.xsis.xsis.model.dhika.PelatihanDika;
import com.xsis.xsis.repository.dhika.PelatihanRepositoryDika;
import com.xsis.xsis.services.dhika.PelatihanServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PelatihanServicesImpl
 */
@Service
@Transactional
public class PelatihanServicesImplDika implements PelatihanServicesDika {

    @Autowired
    private PelatihanRepositoryDika pelatihanRepository;

    @Override
    public PelatihanDika save(PelatihanDika pelatihan) {
        pelatihan.setCreatedBy(2L);
        pelatihan.setCreatedOn(new Date());
        pelatihan.setIsDelete(false);
        return pelatihanRepository.save(pelatihan);
    }

    @Override
    public PelatihanDika update(PelatihanDika pelatihan) {
        PelatihanDika pelatihanDetail = pelatihanRepository.findById(pelatihan.getId()).get();
        pelatihanDetail.setModifiedBy(2L);
        pelatihanDetail.setModifiedOn(new Date());
        pelatihanDetail.setIsDelete(false);
        pelatihanDetail.setId(pelatihan.getId());
        pelatihanDetail.setBiodataId(pelatihan.getBiodataId());
        pelatihanDetail.setTrainingName(pelatihan.getTrainingName());
        pelatihanDetail.setOrganizer(pelatihan.getOrganizer());
        pelatihanDetail.setTrainingYear(pelatihan.getTrainingYear());
        pelatihanDetail.setTrainingMonth(pelatihan.getTrainingMonth());
        pelatihanDetail.setTrainingDuration(pelatihan.getTrainingDuration());
        pelatihanDetail.setTimePeriodId(pelatihan.getTimePeriodId());
        pelatihanDetail.setCity(pelatihan.getCity());
        pelatihanDetail.setCountry(pelatihan.getCountry());
        pelatihanDetail.setNotes(pelatihan.getNotes());
        pelatihanDetail.setCreatedOn(pelatihan.getCreatedOn());
        pelatihanDetail.setCreatedBy(pelatihan.getCreatedBy());
        return pelatihanRepository.save(pelatihan);
    }

    @Override
    public PelatihanDika delete(Long id) {
        PelatihanDika pelatihanEntity = pelatihanRepository.findById(id).get();
        pelatihanEntity.setIsDelete(true);
        pelatihanEntity.setDeletedBy(2L);
        pelatihanEntity.setDeleteddOn(new Date());
        return pelatihanRepository.save(pelatihanEntity);
    }

    @Override
    public Optional<PelatihanDika> getPelatihanById(Long id) {
        return pelatihanRepository.findById(id);
    }

    @Override
    public Iterable<PelatihanDika> findAllPelatihan() {
        return pelatihanRepository.findAll();
    }

    @Override
    public List<pelatihanDtoDika> getPelatihan(Long biodataId) {
        return pelatihanRepository.getPelatihan(biodataId);
    }

    @Override
    public Optional<pelatihanDtoDika> getPelatihanDetail(Long biodataId, Long id) {
        return pelatihanRepository.getPelatihanDetail(biodataId, id);
    }

}