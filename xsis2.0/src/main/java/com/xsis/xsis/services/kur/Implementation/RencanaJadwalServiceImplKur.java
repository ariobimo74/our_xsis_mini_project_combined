package com.xsis.xsis.services.kur.Implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.xsis.xsis.model.kur.RencanaJadwalKur;
import com.xsis.xsis.repository.kur.RencanaJadwalRepositoryKur;
import com.xsis.xsis.services.kur.RencanaJadwalServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Transactional
public class RencanaJadwalServiceImplKur implements RencanaJadwalServiceKur {

    @Autowired
    private RencanaJadwalRepositoryKur rencanaJadwalRepositoryKur;

    @Override
    public List<RencanaJadwalKur> getAll() {
        List<RencanaJadwalKur> pengKerja = new ArrayList<>();
        for (RencanaJadwalKur pengKerjas : rencanaJadwalRepositoryKur.findAll()) {
            if (!pengKerjas.getIsDelete()) {
                pengKerja.add(pengKerjas);
            }
        }
        return pengKerja;
    }

    @Override
    public List<RencanaJadwalKur> searchData(String tgl_mulai, String tgl_sampai) {
        return rencanaJadwalRepositoryKur.searchData(tgl_mulai, tgl_sampai);
    }

    @Override
    public RencanaJadwalKur getById(Long id) {
        return rencanaJadwalRepositoryKur.findById(id).get();
    }

    @Override
    public List<RencanaJadwalKur> getBioId(Long id) {
        return rencanaJadwalRepositoryKur.getBiodataRoTro(id);
    }

    @Override
    public RencanaJadwalKur save(RencanaJadwalKur sumberLoker) {
        sumberLoker.setCreatedBy(1L);
        sumberLoker.setCreatedOn(new Date());
        return rencanaJadwalRepositoryKur.save(sumberLoker);
    }

    @Override
    public RencanaJadwalKur update(RencanaJadwalKur sumberLoker) {
        RencanaJadwalKur pengalaman = rencanaJadwalRepositoryKur.findById(sumberLoker.getId()).get();

        // common entity
        pengalaman.setModifiedBy(1L);
        pengalaman.setModifiedOn(new Date());

        // normal Entity
        pengalaman.setScheduleCode(sumberLoker.getScheduleCode());
        pengalaman.setScheduleDate(sumberLoker.getScheduleDate());
        pengalaman.setTime(sumberLoker.getTime());
        pengalaman.setRo(sumberLoker.getRo());
        pengalaman.setTro(sumberLoker.getTro());
        pengalaman.setScheduleTypeId(sumberLoker.getScheduleTypeId());
        pengalaman.setLocation(sumberLoker.getLocation());
        pengalaman.setOtherRoTro(sumberLoker.getOtherRoTro());
        pengalaman.setNotes(sumberLoker.getNotes());
        pengalaman.setIsAutomaticMail(sumberLoker.isIsAutomaticMail());
        pengalaman.setSentDate(sumberLoker.getSentDate());
        // pengalaman.setStatus(sumberLoker.getStatus());
        return rencanaJadwalRepositoryKur.save(pengalaman);

    }

}