package com.xsis.xsis.services.kur;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.kur.RencanaDetailKur;

/**
 * RencanaDetailService
 */
public interface RencanaDetailServiceKur {
    List<RencanaDetailKur> getRencanDetailAll();

    RencanaDetailKur getById(Long id);

    List<RencanaDetailKur> getRencanaId(Long rencanaId);

    Optional<RencanaDetailKur> getRencanaByIddanRencanaId(Long rencanaId, long biodataId);

}