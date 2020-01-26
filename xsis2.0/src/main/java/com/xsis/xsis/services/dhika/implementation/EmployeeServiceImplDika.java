package com.xsis.xsis.services.dhika.implementation;

import java.util.*;

import com.xsis.xsis.model.dhika.EmployeeDika;
import com.xsis.xsis.repository.dhika.EmployeeRepositoryDika;
import com.xsis.xsis.services.dhika.EmployeeServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeServiceImpl
 */
@Service
public class EmployeeServiceImplDika implements EmployeeServiceDika {

    @Autowired
    private EmployeeRepositoryDika employeeRepository;

    public List<EmployeeDika> getAll() {
        List<EmployeeDika> employee = new ArrayList<>();
        for (EmployeeDika employees : employeeRepository.findAll()) {
            if (!employees.getIsDelete()) {
                employee.add(employees);
            }
        }
        return employee;
    }

    @Override
    public List<EmployeeDika> getRoAndTroByBiodataId(Long id) {
        return employeeRepository.getByBiodataId(id);
    }

    @Override
    public Optional<EmployeeDika> getById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeDika save(EmployeeDika employee) {

        employee.setCreatedBy(2L);
        employee.setCreatedOn(new Date());
        employee.setIsDelete(false);

        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDika update(EmployeeDika employee) {
        EmployeeDika employee2 = employeeRepository.findById(employee.getId()).get();
        employee2.setId(employee.getId());
        employee2.setBiodataId(employee.getBiodataId());
        employee2.setIdle(false);
        employee2.setUserClient(false);
        employee2.setEroEmail(employee.getEroEmail());
        employee2.setModifiedBy(2L);
        employee2.setModifiedOn(new Date());
        return employeeRepository.save(employee2);
    }

    @Override
    public EmployeeDika delete(Long id) {
        EmployeeDika employee = employeeRepository.findById(id).get();
        employee.setIsDelete(true);
        employee.setDeletedBy(1L);
        employee.setDeleteddOn(new Date());
        return employeeRepository.save(employee);
    }

}