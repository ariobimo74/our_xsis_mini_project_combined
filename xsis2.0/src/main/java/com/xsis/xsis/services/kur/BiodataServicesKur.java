package com.xsis.xsis.services.kur;

import java.util.Optional;

import com.xsis.xsis.model.kur.BiodataKur;

import org.springframework.data.repository.query.Param;

/**
 * BiodataServices
 */
public interface BiodataServicesKur {

    // Get Data Biodata
    Iterable<BiodataKur> getBiodata();

    // Get Data Biodata Detail
    Optional<BiodataKur> getBiodataById(@Param("id") Long id);
}