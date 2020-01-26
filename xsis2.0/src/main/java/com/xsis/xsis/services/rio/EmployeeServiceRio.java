package com.xsis.xsis.services.rio;

import com.xsis.xsis.dto.rio.EmployeeDtoRio;
import com.xsis.xsis.model.rio.EmployeeEntityRio;
import com.xsis.xsis.repository.rio.EmployeeRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceRio {
    @Autowired
    private EmployeeRepositoryRio employeeRepository;

    public Iterable<EmployeeEntityRio> getEmployeeEntity() {
        List<EmployeeEntityRio> employeeEntities = new ArrayList<>();
        for (EmployeeEntityRio employeeEntity : employeeRepository.findAll()) {
            if (!employeeEntity.getIsDelete()) {
                employeeEntities.add(employeeEntity);
            }
        }
        return employeeEntities;
    }

    public Optional<EmployeeEntityRio> findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public List<EmployeeDtoRio> getAllEmployeeMapping() {
        return employeeRepository.getAllEmployeeMapping();
    }

    public List<EmployeeDtoRio> getBioId(int biodataId) {
        return employeeRepository.getBioId(biodataId);
    }
}
