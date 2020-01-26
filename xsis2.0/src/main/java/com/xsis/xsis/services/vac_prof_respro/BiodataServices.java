package com.xsis.xsis.services.vac_prof_respro;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.vac_prof_respro.Biodata;

import org.springframework.data.repository.query.Param;

/**
 * BiodataServices
 */
public interface BiodataServices {

    // Get Data Biodata
    Iterable<Biodata> getBiodata();

    // Get Data Biodata Detail
    Optional<Biodata> getBiodataById(@Param("id") Long id);

    // Get Data Search Biodata
    List<Biodata> getPelamar(String pelamar);
}