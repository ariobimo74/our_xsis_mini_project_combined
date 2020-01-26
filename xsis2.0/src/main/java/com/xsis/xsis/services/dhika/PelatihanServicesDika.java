package com.xsis.xsis.services.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.dhika.pelatihanDtoDika;
import com.xsis.xsis.model.dhika.PelatihanDika;

import org.springframework.data.repository.query.Param;

/**
 * PelatihanServices
 */
public interface PelatihanServicesDika {

    // Untuk Simpan Pelatihan Pelamar
    PelatihanDika save(PelatihanDika pelatihan);

    // Untuk Update Pelatihan Pelamar
    PelatihanDika update(PelatihanDika pelatihan);

    PelatihanDika delete(Long id);

    // Untuk Mendapatkan daftar Data Pelatihan Pelamar
    Iterable<PelatihanDika> findAllPelatihan();

    // Untuk Mendapatkan data Pelatihan Pelamar Berdasarkan ID
    Optional<PelatihanDika> getPelatihanById(@Param("id") Long id);

    // Pelatihan Join Time Period
    List<pelatihanDtoDika> getPelatihan(Long biodataId);

    // Pelatihan Join Time Period Detail
    Optional<pelatihanDtoDika> getPelatihanDetail(Long biodataId, Long id);

}