package com.xsis.xsis.services.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.fathan.OnlineTestDto;
import com.xsis.xsis.model.fathan.OnlineTest;

import org.springframework.data.repository.query.Param;

/**
 * OnlineTestService
 */
public interface OnlineTestService {

    List<OnlineTest> getAll();

    Optional<OnlineTest> getById(Long id);

    OnlineTest save(OnlineTest onlineTest);

    OnlineTest edit(OnlineTest onlineTest);

    OnlineTest delete(Long id);

    List<OnlineTestDto> getBioId(Long biodataId);

    Iterable<OnlineTest> getLastId();

    Iterable<OnlineTest> getLastPeriod(@Param("biodataId") Long id);

    OnlineTest ubahStatus(@Param("biodataId") Long id);

    Iterable<OnlineTest> getLastCodePeriode();

}