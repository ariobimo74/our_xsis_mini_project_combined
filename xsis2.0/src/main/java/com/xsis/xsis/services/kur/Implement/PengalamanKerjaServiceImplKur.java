package com.xsis.xsis.services.kur.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.xsis.xsis.dto.kur.BiodataPengkerDtoKur;
import com.xsis.xsis.model.kur.entity.PengalamanKerjaKur;
import com.xsis.xsis.repository.kur.PengalamanKerjaRepositoryKur;
import com.xsis.xsis.services.kur.PengalamanKerjaServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PengalamanKerjaServiceImpl
 */
@Service
@Transactional
public class PengalamanKerjaServiceImplKur implements PengalamanKerjaServiceKur {

    @Autowired
    private PengalamanKerjaRepositoryKur pengalamanKerjaRepository;

    @Override
    public PengalamanKerjaKur getById(Long id) {
        return pengalamanKerjaRepository.findById(id).get();
    }

    @Override
    public List<PengalamanKerjaKur> getAll() {
        List<PengalamanKerjaKur> pengKerja = new ArrayList<>();
        for (PengalamanKerjaKur pengKerjas : pengalamanKerjaRepository.findAll()) {
            if (!pengKerjas.getIsDelete()) {
                pengKerja.add(pengKerjas);
            }
        }
        return pengKerja;
    }

    @Override
    public PengalamanKerjaKur save(PengalamanKerjaKur pengalamanKerja) {
        pengalamanKerja.setCreatedBy(1L);
        pengalamanKerja.setCreatedOn(new Date());
        return pengalamanKerjaRepository.save(pengalamanKerja);
    }

    @Override
    public PengalamanKerjaKur update(PengalamanKerjaKur pengalamanKerja) {
        PengalamanKerjaKur pengalaman = pengalamanKerjaRepository.findById(pengalamanKerja.getId()).get();

        // common entity
        pengalaman.setModifiedBy(1L);
        pengalaman.setModifiedOn(new Date());

        // normal Entity
        pengalaman.setBiodataId(pengalamanKerja.getBiodataId());
        pengalaman.setCompanyName(pengalamanKerja.getCompanyName());
        pengalaman.setCity(pengalamanKerja.getCity());
        pengalaman.setCountry(pengalamanKerja.getCountry());
        pengalaman.setJoinYear(pengalamanKerja.getJoinYear());
        pengalaman.setJoinMonth(pengalamanKerja.getJoinMonth());
        pengalaman.setResignYear(pengalamanKerja.getResignYear());
        pengalaman.setResignMonth(pengalamanKerja.getResignMonth());
        pengalaman.setLastPosition(pengalamanKerja.getLastPosition());
        pengalaman.setIncome(pengalamanKerja.getIncome());
        pengalaman.setIsItRelated(pengalamanKerja.getIsItRelated());
        pengalaman.setAboutJob(pengalamanKerja.getAboutJob());
        pengalaman.setExitReason(pengalamanKerja.getExitReason());
        pengalaman.setAboutJob(pengalamanKerja.getAboutJob());
        pengalaman.setNotes(pengalamanKerja.getNotes());

        return pengalamanKerjaRepository.save(pengalaman);

    }

    @Override
    public PengalamanKerjaKur delete(Long id) {
        PengalamanKerjaKur pengalaman = pengalamanKerjaRepository.findById(id).get();
        pengalaman.setIsDelete(true);
        pengalaman.setDeletedBy(1L);
        pengalaman.setDeleteddOn(new Date());
        return pengalamanKerjaRepository.save(pengalaman);
    }

    @Override
    public List<BiodataPengkerDtoKur> getBioId(Long biodataId) {
        return pengalamanKerjaRepository.getBioId(biodataId);
    }

}