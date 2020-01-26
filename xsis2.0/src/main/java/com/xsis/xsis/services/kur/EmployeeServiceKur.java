package com.xsis.xsis.services.kur;

import java.util.List;

import com.xsis.xsis.model.kur.EmployeeKur;

/**
 * EmployeeService
 */
public interface EmployeeServiceKur {

    List<EmployeeKur> getBioRoTro(Long id);

    List<EmployeeKur> getAllTrueEro();

    List<EmployeeKur> getAllEmp();

}