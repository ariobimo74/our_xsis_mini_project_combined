package com.xsis.xsis.services.fia.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.xsis.xsis.dto.fia.SertifikasiBioDtoAlfia;
import com.xsis.xsis.model.fia.SertifikasiAlfia;
import com.xsis.xsis.repository.fia.SertifikasiRepositoryAlfia;
import com.xsis.xsis.services.fia.SertifikasiServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SertifikasiServiceImpl
 */
@Service
@Transactional
public class SertifikasiServiceImplAlfia implements SertifikasiServiceAlfia {
    @Autowired
    private SertifikasiRepositoryAlfia sertifikasiRepository;

    @Override
    public SertifikasiAlfia getById(Long id) {
        return sertifikasiRepository.findById(id).get();
    }

    @Override
    public List<SertifikasiAlfia> getAll() {
        List<SertifikasiAlfia> sertif = new ArrayList<>();
        for (SertifikasiAlfia sertifs : sertifikasiRepository.findAll()) {
            if (!sertifs.getIsDelete()) {
                sertif.add(sertifs);
            }
        }
        return sertif;
    }

    @Override
    public SertifikasiAlfia save(SertifikasiAlfia sertifikasi) {
        sertifikasi.setCreatedBy(2L);
        sertifikasi.setCreatedOn(new Date());
        return sertifikasiRepository.save(sertifikasi);
    }

    @Override
    public SertifikasiAlfia update(SertifikasiAlfia sertifikasi) {
        SertifikasiAlfia sertif = sertifikasiRepository.findById(sertifikasi.getId()).get();

        sertif.setModifiedBy(2L);
        sertif.setModifiedOn(new Date());

        sertif.setBiodataId(sertifikasi.getBiodataId());
        sertif.setCertificateName(sertifikasi.getCertificateName());
        sertif.setPublisher(sertifikasi.getPublisher());
        sertif.setValidStartYear(sertifikasi.getValidStartYear());
        sertif.setValidStartMonth(sertifikasi.getValidStartMonth());
        sertif.setUntilYear(sertifikasi.getUntilYear());
        sertif.setUntilMonth(sertifikasi.getUntilMonth());
        sertif.setNotes(sertifikasi.getNotes());

        return sertifikasiRepository.save(sertif);
    }

    @Override
    public SertifikasiAlfia delete(Long id) {
        SertifikasiAlfia sertif = sertifikasiRepository.findById(id).get();
        sertif.setIsDelete(true);
        sertif.setDeletedBy(2L);
        sertif.setDeleteddOn(new Date());
        return sertifikasiRepository.save(sertif);
    }

    @Override
    public List<SertifikasiBioDtoAlfia> getBioId(Long biodataId) {
        return sertifikasiRepository.getBioId(biodataId);
    }
}