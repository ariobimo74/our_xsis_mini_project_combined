package com.xsis.xsis.repository.fathan;

import java.util.List;

import com.xsis.xsis.dto.fathan.OnlineTestDto;
import com.xsis.xsis.model.fathan.OnlineTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * OnlineTestRepository
 */
public interface OnlineTestRepository extends JpaRepository<OnlineTest, Long> {

    @Query(nativeQuery = true)
    List<OnlineTestDto> getBioId(Long biodataId);

    @Query(value = "select * from x_online_test where isdelete=false order by created_on DESC limit 1", nativeQuery = true)
    Iterable<OnlineTest> getLastId();

    @Query(value = "select * from x_online_test where isdelete=false and biodata_id=:biodataId order by period Desc limit 1", nativeQuery = true)
    Iterable<OnlineTest> getLastPeriod(@Param("biodataId") Long id);

    @Query(value = "select * from x_online_test where isdelete=false and biodata_id=:biodataId order by period Desc limit 1", nativeQuery = true)
    OnlineTest getLastStatus(@Param("biodataId") Long id);

    @Query(value = "select * from x_online_test where isdelete=false order by period_code Desc limit 1", nativeQuery = true)
    Iterable<OnlineTest> getLastCodePeriode();

}