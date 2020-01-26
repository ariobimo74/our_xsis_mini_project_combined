package com.xsis.xsis.repository.vac_prof_respro;

import com.xsis.xsis.dto.vac_prof_respro.ClientEmployeeDto;
import com.xsis.xsis.model.vac_prof_respro.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * ClientRepository
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true)
    Iterable<ClientEmployeeDto> getClientSelectOption();

}