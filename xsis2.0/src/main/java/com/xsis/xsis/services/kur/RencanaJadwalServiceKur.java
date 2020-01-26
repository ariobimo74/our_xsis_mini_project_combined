package com.xsis.xsis.services.kur;

import java.util.List;

import com.xsis.xsis.model.kur.RencanaJadwalKur;

public interface RencanaJadwalServiceKur {

    List<RencanaJadwalKur> getAll();

    List<RencanaJadwalKur> getBioId(Long id);

    List<RencanaJadwalKur> searchData(String tgl_mulai, String tgl_sampai);

    RencanaJadwalKur getById(Long id);

    RencanaJadwalKur save(RencanaJadwalKur sumberLoker);

    RencanaJadwalKur update(RencanaJadwalKur sumberLoker);

}