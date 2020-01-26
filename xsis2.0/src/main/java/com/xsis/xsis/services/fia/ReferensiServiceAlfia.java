package com.xsis.xsis.services.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.ReferensiBioDtoAlfia;
import com.xsis.xsis.model.fia.ReferensiAlfia;

/**
 * ReferensiService
 */
public interface ReferensiServiceAlfia {

    List<ReferensiAlfia> getAll();

    ReferensiAlfia getById(Long id);

    ReferensiAlfia save(ReferensiAlfia referensi);

    ReferensiAlfia update(ReferensiAlfia referensi);

    ReferensiAlfia delete(Long id);

    List<ReferensiBioDtoAlfia> getBioId(Long biodataId);
}