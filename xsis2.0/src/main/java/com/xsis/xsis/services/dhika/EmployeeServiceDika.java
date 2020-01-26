package com.xsis.xsis.services.dhika;

import java.util.*;

import com.xsis.xsis.model.dhika.EmployeeDika;

/**
 * EmployeeService
 */

public interface EmployeeServiceDika {

    List<EmployeeDika> getAll();

    List<EmployeeDika> getRoAndTroByBiodataId(Long id);

    EmployeeDika save(EmployeeDika employee);

    Optional<EmployeeDika> getById(Long id);

    EmployeeDika update(EmployeeDika employee);

    EmployeeDika delete(Long id);

}