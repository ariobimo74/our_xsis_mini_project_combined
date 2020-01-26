package com.xsis.xsis.services.fathan;

import java.util.List;

import com.xsis.xsis.model.fathan.entity.PengalamanKerjaFathan;

/**
 * PengalamanKerjaService
 */
public interface PengalamanKerjaServiceFathan {

    List<PengalamanKerjaFathan> getAll();

    PengalamanKerjaFathan getById(Long id);

    PengalamanKerjaFathan save(PengalamanKerjaFathan pengalamanKerja);

    PengalamanKerjaFathan update(PengalamanKerjaFathan pengalamanKerja);

    PengalamanKerjaFathan delete(Long id);

}