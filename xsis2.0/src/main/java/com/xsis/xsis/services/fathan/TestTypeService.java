package com.xsis.xsis.services.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.TestType;

/**
 * TestTypeService
 */
public interface TestTypeService {

    List<TestType> getAll();

    Optional<TestType> getById(Long id);

    TestType save(TestType testType);

    TestType edit(TestType testType);

    TestType delete(Long id);


    // List<TestTypeDto> getBioId(Long biodataId);
}