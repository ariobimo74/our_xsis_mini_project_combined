package com.xsis.xsis.repository.kur;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.kur.RencanaDetailKur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * RencanaDetailRepository
 */

public interface RencanaDetailRepositoryKur extends JpaRepository<RencanaDetailKur, Long> {

    @Query(value = "select * from x_rencana_jadwal_detail WHERE rencana_jadwal_id = ?1 and isdelete = false", nativeQuery = true)
    List<RencanaDetailKur> get_rencana_detail(Long rencanaId);

    @Query(value = "select * from x_rencana_jadwal_detail WHERE rencana_jadwal_id = ?1 and biodata_id = ?2  and isdelete = false ", nativeQuery = true)
    Optional<RencanaDetailKur> getRencanaByBiodataIdandRencanaId(Long rencanaId, long biodataId);

}