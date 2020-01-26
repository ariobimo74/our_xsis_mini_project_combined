package com.xsis.xsis.repository.kur;

import java.util.List;

import com.xsis.xsis.dto.kur.BiodataPengkerDtoKur;
import com.xsis.xsis.model.kur.entity.PengalamanKerjaKur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PengalamanKerjaRepository
 */
public interface PengalamanKerjaRepositoryKur extends JpaRepository<PengalamanKerjaKur, Long> {
    @Query(nativeQuery = true)
    List<BiodataPengkerDtoKur> getBioId(Long biodataId);

    // @Query(value = "select * from x_biodata WHERE id = ?1", nativeQuery = true)
    // List<RencanaJadwal> getBiodataRoTro(Long id);

}