package com.xsis.xsis.services.dhika;

import java.util.Optional;

import com.xsis.xsis.model.dhika.BiodataDika;

import org.springframework.data.repository.query.Param;

/**
 * BiodataServices
 */
public interface BiodataServicesDika {

    // Get Data Biodata
    Iterable<BiodataDika> getBiodata();

    // Get Data Biodata Detail
    Optional<BiodataDika> getBiodataById(@Param("id") Long id);
}