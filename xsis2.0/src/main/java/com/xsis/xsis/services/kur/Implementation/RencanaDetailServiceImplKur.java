package com.xsis.xsis.services.kur.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.kur.RencanaDetailKur;
import com.xsis.xsis.repository.kur.RencanaDetailRepositoryKur;
import com.xsis.xsis.services.kur.RencanaDetailServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RencanaDetailServiceImpl
 */
@Service
public class RencanaDetailServiceImplKur implements RencanaDetailServiceKur {

    @Autowired
    private RencanaDetailRepositoryKur rencanaDetailRepositoryKur;

    @Override
    public List<RencanaDetailKur> getRencanDetailAll() {
        List<RencanaDetailKur> pengKerja = new ArrayList<>();
        for (RencanaDetailKur pengKerjas : rencanaDetailRepositoryKur.findAll()) {
            if (!pengKerjas.getIsDelete()) {
                pengKerja.add(pengKerjas);
            }
        }
        return pengKerja;
    }

    @Override
    public RencanaDetailKur getById(Long id) {
        return rencanaDetailRepositoryKur.findById(id).get();
    }

    @Override
    public List<RencanaDetailKur> getRencanaId(Long rencanaId) {
        return rencanaDetailRepositoryKur.get_rencana_detail(rencanaId);
    }

    @Override
    public Optional<RencanaDetailKur> getRencanaByIddanRencanaId(Long rencanaId, long biodataId) {
        return rencanaDetailRepositoryKur.getRencanaByBiodataIdandRencanaId(rencanaId, biodataId);
    }

}