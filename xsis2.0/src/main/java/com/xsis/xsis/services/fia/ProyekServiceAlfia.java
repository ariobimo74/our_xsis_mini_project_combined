package com.xsis.xsis.services.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.ProyekBioDtoAlfia;
import com.xsis.xsis.model.fia.RiwayatProyekAlfia;

public interface ProyekServiceAlfia {

    List<ProyekBioDtoAlfia> getPengkerId(Long riwayatPekerjaanId);

    RiwayatProyekAlfia getById(Long id);

    RiwayatProyekAlfia save(RiwayatProyekAlfia riwayatProyek);

    RiwayatProyekAlfia update(RiwayatProyekAlfia riwayatProyek);

    RiwayatProyekAlfia delete(Long id);

}