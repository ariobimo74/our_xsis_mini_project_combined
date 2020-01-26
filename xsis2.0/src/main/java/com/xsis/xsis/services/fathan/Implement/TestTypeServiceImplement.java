package com.xsis.xsis.services.fathan.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.TestType;
import com.xsis.xsis.repository.fathan.TestTypeRepository;
import com.xsis.xsis.services.fathan.TestTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TestTypeServiceImplement
 */
@Service
public class TestTypeServiceImplement implements TestTypeService {
    @Autowired
    private TestTypeRepository testTypeRepository;

    @Override
    public List<TestType> getAll() {
        List<TestType> type = new ArrayList<>();
        for (TestType types : testTypeRepository.findAll()) {
            if (!types.getIsDelete()) {
                type.add(types);
            }

        }
        return type;
    }

    @Override
    public Optional<TestType> getById(Long id) {
        return testTypeRepository.findById(id);
    }

    @Override
    public TestType save(TestType testType) {
        testType.setCreatedBy(9L);
        testType.setCreatedOn(new Date());
        testType.setIsDelete(false);
        return testTypeRepository.save(testType);
    }

    @Override
    public TestType edit(TestType testType) {
        TestType type = testTypeRepository.findById(testType.getId()).get();
        type.setModifiedBy(9L);
        type.setModifiedOn(new Date());
        type.setId(testType.getId());
        type.setName(testType.getName());
        type.setDescription(testType.getDescription());
        return testTypeRepository.save(type);
    }

    @Override
    public TestType delete(Long id) {
        TestType type = testTypeRepository.findById(id).get();
        type.setIsDelete(true);
        type.setDeletedBy(9L);
        type.setDeleteddOn(new Date());
        return testTypeRepository.save(type);
    }
}