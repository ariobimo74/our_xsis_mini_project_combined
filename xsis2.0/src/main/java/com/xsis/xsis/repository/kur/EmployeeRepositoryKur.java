package com.xsis.xsis.repository.kur;

import java.util.List;

import com.xsis.xsis.model.kur.EmployeeKur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * EmployeeRepository
 */

public interface EmployeeRepositoryKur extends JpaRepository<EmployeeKur, Long> {

    @Query(value = "select * from x_employee WHERE biodata_id = ?1 and isdelete=false and is_ero=true", nativeQuery = true)
    List<EmployeeKur> getBiodataRoTro(Long id);

}