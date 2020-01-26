package com.xsis.xsis.services.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.fathan.OnlineTestDetailDto;
import com.xsis.xsis.model.fathan.OnlineTestDetail;

import org.springframework.data.repository.query.Param;

/**
 * OnlineTestDetailService
 */
public interface OnlineTestDetailService {

    List<OnlineTestDetail> getAll();

    Optional<OnlineTestDetail> getById(Long id);

    OnlineTestDetail save(OnlineTestDetail onlineTestDetail);

    OnlineTestDetail edit(OnlineTestDetail onlineTestDetail);

    OnlineTestDetail delete(Long id);

    List<OnlineTestDetailDto> getOltId(Long onlineTestId);

    Iterable<OnlineTestDetail> getLastOrder(@Param("onlineTestId") Long onlineTestId);

}