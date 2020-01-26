package com.xsis.xsis.services.fia.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.xsis.xsis.dto.fia.KeteranganBioDtoAlfia;
import com.xsis.xsis.model.fia.KeteranganAlfia;
import com.xsis.xsis.repository.fia.KeteranganRepositoryAlfia;
import com.xsis.xsis.services.fia.KeteranganServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * KeteranganServiceImp
 */
@Service
@Transactional
public class KeteranganServiceImpAlfia implements KeteranganServiceAlfia {
    @Autowired
    private KeteranganRepositoryAlfia keteranganRepository;

    @Override
    public KeteranganAlfia getById(Long id) {
        return keteranganRepository.findById(id).get();
    }

    @Override
    public List<KeteranganAlfia> getAll() {
        List<KeteranganAlfia> ket = new ArrayList<>();
        for (KeteranganAlfia kets : keteranganRepository.findAll()) {
            if (!kets.getIsDelete()) {
                ket.add(kets);
            }
        }
        return ket;
    }

    @Override
    public KeteranganAlfia save(KeteranganAlfia keterangan) {
        keterangan.setCreatedBy(2L);
        keterangan.setCreatedOn(new Date());
        return keteranganRepository.save(keterangan);
    }

    @Override
    public KeteranganAlfia update(KeteranganAlfia keterangan) {
        KeteranganAlfia ket = keteranganRepository.findById(keterangan.getId()).get();

        ket.setModifiedBy(2L);
        ket.setModifiedOn(new Date());

        ket.setBiodataId(keterangan.getBiodataId());
        ket.setEmergencyContactName(keterangan.getEmergencyContactName());
        ket.setEmergencyContactPhone(keterangan.getEmergencyContactPhone());
        ket.setExpectedSalary(keterangan.getExpectedSalary());
        ket.setIsNegotiable(keterangan.getIsNegotiable());
        ket.setStartWorking(keterangan.getStartWorking());
        ket.setIsReadyToOutoftown(keterangan.getIsReadyToOutoftown());
        ket.setIsApplyOtherPlace(keterangan.getIsApplyOtherPlace());
        ket.setApplyPlace(keterangan.getApplyPlace());
        ket.setSelectionPhase(keterangan.getSelectionPhase());
        ket.setIsEverBadlySick(keterangan.getIsEverBadlySick());
        ket.setDiseaseName(keterangan.getDiseaseName());
        ket.setDiseaseTime(keterangan.getDiseaseTime());
        ket.setIsEverPsychotest(keterangan.getIsEverPsychotest());
        ket.setPsychotestNeeds(keterangan.getPsychotestNeeds());
        ket.setPsychotestTime(keterangan.getPsychotestTime());
        ket.setRequirementesRequired(keterangan.getRequirementesRequired());
        ket.setOtherNotes(keterangan.getOtherNotes());

        return keteranganRepository.save(ket);
    }

    @Override
    public KeteranganAlfia delete(Long id) {
        KeteranganAlfia ket = keteranganRepository.findById(id).get();
        ket.setIsDelete(true);
        ket.setDeletedBy(2L);
        ket.setDeleteddOn(new Date());
        return keteranganRepository.save(ket);
    }

    @Override
    public Optional<KeteranganBioDtoAlfia> getBioId(Long biodataId) {
        return keteranganRepository.getBioId(biodataId);
    }
}