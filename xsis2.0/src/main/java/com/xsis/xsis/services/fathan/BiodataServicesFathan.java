package com.xsis.xsis.services.fathan;

import java.util.Optional;

import com.xsis.xsis.model.fathan.BiodataFathan;

import org.springframework.data.repository.query.Param;

/**
 * BiodataServices
 */
public interface BiodataServicesFathan {

    // Get Data Biodata
    Iterable<BiodataFathan> getBiodata();

    // Get Data Biodata Detail
    Optional<BiodataFathan> getBiodataById(@Param("id") Long id);

    BiodataFathan edit(BiodataFathan biodata);
}