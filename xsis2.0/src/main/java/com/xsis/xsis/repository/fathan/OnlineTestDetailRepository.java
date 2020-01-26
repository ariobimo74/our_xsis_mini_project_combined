package com.xsis.xsis.repository.fathan;

import java.util.List;

import com.xsis.xsis.dto.fathan.OnlineTestDetailDto;
import com.xsis.xsis.model.fathan.OnlineTestDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * OnlineTestDetailRepository
 */
public interface OnlineTestDetailRepository extends JpaRepository<OnlineTestDetail, Long> {

    @Query(nativeQuery = true)
    List<OnlineTestDetailDto> getOltId(Long onlineTestId);

    @Query(value = "select * from x_online_test_detail where online_test_id=:onlineTestId and "
            + "isdelete=false order by test_order DESC limit 1", nativeQuery = true)
    Iterable<OnlineTestDetail> getLastOrder(@Param("onlineTestId") Long onlineTestId);

}