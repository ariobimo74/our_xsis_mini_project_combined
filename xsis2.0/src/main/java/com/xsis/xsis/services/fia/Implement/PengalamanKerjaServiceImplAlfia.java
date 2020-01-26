package com.xsis.xsis.services.fia.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.xsis.xsis.dto.fia.BiodataPengkerDtoAlfia;
import com.xsis.xsis.model.fia.PengalamanKerjaAlfia;
import com.xsis.xsis.repository.fia.PengalamanKerjaRepositoryAlfia;
import com.xsis.xsis.services.fia.PengalamanKerjaServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PengalamanKerjaServiceImpl
 */
@Service
@Transactional
public class PengalamanKerjaServiceImplAlfia implements PengalamanKerjaServiceAlfia {

    @Autowired
    private PengalamanKerjaRepositoryAlfia pengalamanKerjaRepository;

    @Override
    public PengalamanKerjaAlfia getById(Long id) {
        return pengalamanKerjaRepository.findById(id).get();
    }

    @Override
    public List<PengalamanKerjaAlfia> getAll() {
        List<PengalamanKerjaAlfia> pengKerja = new ArrayList<>();
        for (PengalamanKerjaAlfia pengKerjas : pengalamanKerjaRepository.findAll()) {
            if (!pengKerjas.getIsDelete()) {
                pengKerja.add(pengKerjas);
            }
        }
        return pengKerja;
    }

    @Override
    public PengalamanKerjaAlfia save(PengalamanKerjaAlfia pengalamanKerja) {
        pengalamanKerja.setCreatedBy(1L);
        pengalamanKerja.setCreatedOn(new Date());
        return pengalamanKerjaRepository.save(pengalamanKerja);
    }

    @Override
    public PengalamanKerjaAlfia update(PengalamanKerjaAlfia pengalamanKerja) {
        PengalamanKerjaAlfia pengalaman = pengalamanKerjaRepository.findById(pengalamanKerja.getId()).get();

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
    public PengalamanKerjaAlfia delete(Long id) {
        PengalamanKerjaAlfia pengalaman = pengalamanKerjaRepository.findById(id).get();
        pengalaman.setIsDelete(true);
        pengalaman.setDeletedBy(1L);
        pengalaman.setDeleteddOn(new Date());
        return pengalamanKerjaRepository.save(pengalaman);
    }

    @Override
    public List<BiodataPengkerDtoAlfia> getBioId(Long biodataId) {
        return pengalamanKerjaRepository.getBioId(biodataId);
    }

}