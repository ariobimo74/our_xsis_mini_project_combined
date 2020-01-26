package com.xsis.xsis.services.fia.Implement;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.xsis.xsis.dto.fia.ProyekBioDtoAlfia;
import com.xsis.xsis.model.fia.RiwayatProyekAlfia;
import com.xsis.xsis.repository.fia.ProyekRepositoryAlfia;
import com.xsis.xsis.services.fia.ProyekServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyekServiceImpAlfia implements ProyekServiceAlfia {
    @Autowired
    private ProyekRepositoryAlfia proyekRepository;

    @Override
    public List<ProyekBioDtoAlfia> getPengkerId(Long riwayatPekerjaanId) {
        return proyekRepository.getPengkerId(riwayatPekerjaanId);
    }

    @Override
    public RiwayatProyekAlfia getById(Long id) {
        return proyekRepository.findById(id).get();
    }

    @Override
    public RiwayatProyekAlfia save(RiwayatProyekAlfia riwayatProyek) {
        riwayatProyek.setCreatedBy(2L);
        riwayatProyek.setCreatedOn(new Date());
        return proyekRepository.save(riwayatProyek);
    }

    @Override
    public RiwayatProyekAlfia update(RiwayatProyekAlfia riwayatProyek) {
        RiwayatProyekAlfia proy = proyekRepository.findById(riwayatProyek.getId()).get();
        proy.setModifiedBy(2L);
        proy.setModifiedOn(new Date());

        proy.setRiwayatPekerjaanId(riwayatProyek.getRiwayatPekerjaanId());
        proy.setStartYear(riwayatProyek.getStartYear());
        proy.setStartMonth(riwayatProyek.getStartMonth());
        proy.setProjectName(riwayatProyek.getProjectName());
        proy.setProjectDuration(riwayatProyek.getProjectDuration());
        proy.setTimePeriodId(riwayatProyek.getTimePeriodId());
        proy.setClient(riwayatProyek.getClient());
        proy.setProjectPosition(riwayatProyek.getProjectPosition());
        proy.setDescription(riwayatProyek.getDescription());

        return proyekRepository.save(proy);
    }

    @Override
    public RiwayatProyekAlfia delete(Long id) {
        RiwayatProyekAlfia proy = proyekRepository.findById(id).get();
        proy.setIsDelete(true);
        proy.setDeletedBy(2L);
        proy.setDeleteddOn(new Date());
        return proyekRepository.save(proy);
    }

}