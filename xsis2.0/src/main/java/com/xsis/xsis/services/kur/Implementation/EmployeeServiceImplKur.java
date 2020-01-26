package com.xsis.xsis.services.kur.Implementation;

import java.util.ArrayList;
import java.util.List;

import com.xsis.xsis.model.kur.EmployeeKur;
import com.xsis.xsis.repository.kur.EmployeeRepositoryKur;
import com.xsis.xsis.services.kur.EmployeeServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeServiceImpl
 */
@Service
public class EmployeeServiceImplKur implements EmployeeServiceKur {

    @Autowired
    private EmployeeRepositoryKur employeeRepositoryKur;

    @Override
    public List<EmployeeKur> getBioRoTro(Long id) {
        return employeeRepositoryKur.getBiodataRoTro(id);
    }

    @Override
    public List<EmployeeKur> getAllTrueEro() {
        List<EmployeeKur> pengKerja = new ArrayList<>();
        for (EmployeeKur pengKerjas : employeeRepositoryKur.findAll()) {
            if (pengKerjas.isIsEro() && !pengKerjas.getIsDelete()) {
                pengKerja.add(pengKerjas);
            }
        }
        return pengKerja;
    }

    @Override
    public List<EmployeeKur> getAllEmp() {
        List<EmployeeKur> pengKerja = new ArrayList<>();
        for (EmployeeKur pengKerjas : employeeRepositoryKur.findAll()) {
            if (pengKerjas.isIsEro() && !pengKerjas.getIsDelete()) {
                pengKerja.add(pengKerjas);
            }
        }
        return pengKerja;
    }

}
