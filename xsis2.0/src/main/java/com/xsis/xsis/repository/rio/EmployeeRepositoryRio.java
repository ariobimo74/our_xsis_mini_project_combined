package com.xsis.xsis.repository.rio;

import com.xsis.xsis.dto.rio.EmployeeDtoRio;
import com.xsis.xsis.model.rio.EmployeeEntityRio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepositoryRio extends JpaRepository<EmployeeEntityRio, Long>
{
    @Query(nativeQuery = true)
    List<EmployeeDtoRio> getAllEmployeeMapping();

    @Query(nativeQuery = true)
    List<EmployeeDtoRio> getBioId(int biodataId);
}
