package com.xsis.xsis.repository.kur;

import java.util.List;

import com.xsis.xsis.model.kur.RencanaJadwalKur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RencanaJadwalRepositoryKur extends JpaRepository<RencanaJadwalKur, Long> {

    @Query(value = "select * from x_biodata WHERE id = ?1", nativeQuery = true)
    List<RencanaJadwalKur> getBiodataRoTro(Long id);

    // to_date('20170103','YYYYMMDD')
    static final String CARI_DATA = "SELECT * FROM x_rencana_jadwal WHERE CAST(schedule_date AS VARCHAR) BETWEEN :tgl_mulai AND :tgl_sampai ORDER BY schedule_date";

    @Query(value = CARI_DATA, nativeQuery = true)
    List<RencanaJadwalKur> searchData(@Param("tgl_mulai") String tgl_mulai, @Param("tgl_sampai") String tgl_sampai);

}