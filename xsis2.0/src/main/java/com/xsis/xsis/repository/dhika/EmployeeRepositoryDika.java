package com.xsis.xsis.repository.dhika;

import java.util.List;

import com.xsis.xsis.model.dhika.EmployeeDika;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepositoryDika extends JpaRepository<EmployeeDika, Long> {

    @Query(value = "SELECT * FROM x_employee where biodata_id = ?1", nativeQuery = true)
    List<EmployeeDika> getByBiodataId(Long id);

}