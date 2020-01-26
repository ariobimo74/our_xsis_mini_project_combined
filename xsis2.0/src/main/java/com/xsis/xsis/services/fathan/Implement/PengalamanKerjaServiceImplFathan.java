package com.xsis.xsis.services.fathan.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xsis.xsis.model.fathan.entity.PengalamanKerjaFathan;
import com.xsis.xsis.repository.fathan.PengalamanKerjaRepositoryFathan;
import com.xsis.xsis.services.fathan.PengalamanKerjaServiceFathan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PengalamanKerjaServiceImpl
 */
@Service
public class PengalamanKerjaServiceImplFathan implements PengalamanKerjaServiceFathan {

    @Autowired
    private PengalamanKerjaRepositoryFathan pengalamanKerjaRepository;

    @Override
    public PengalamanKerjaFathan getById(Long id) {
        return pengalamanKerjaRepository.findById(id).get();
    }

    @Override
    public List<PengalamanKerjaFathan> getAll() {
        List<PengalamanKerjaFathan> pengKerja = new ArrayList<>();
        for (PengalamanKerjaFathan pengKerjas : pengalamanKerjaRepository.findAll()) {
            if (!pengKerjas.getIsDelete()) {
                pengKerja.add(pengKerjas);
            }
        }
        return pengKerja;
    }

    @Override
    public PengalamanKerjaFathan save(PengalamanKerjaFathan pengalamanKerja) {
        pengalamanKerja.setCreatedBy(1L);
        pengalamanKerja.setCreatedOn(new Date());
        return pengalamanKerjaRepository.save(pengalamanKerja);
    }

    @Override
    public PengalamanKerjaFathan update(PengalamanKerjaFathan pengalamanKerja) {
        PengalamanKerjaFathan pengalaman = pengalamanKerjaRepository.findById(pengalamanKerja.getId()).get();
        pengalaman.setModifiedBy(1L);

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
    public PengalamanKerjaFathan delete(Long id) {
        PengalamanKerjaFathan pengalaman = pengalamanKerjaRepository.findById(id).get();
        pengalaman.setIsDelete(true);
        pengalaman.setDeletedBy(1L);
        pengalaman.setDeleteddOn(new Date());
        return pengalamanKerjaRepository.save(pengalaman);
    }

}