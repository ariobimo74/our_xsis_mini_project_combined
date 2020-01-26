package com.xsis.xsis.services.vac_prof_respro;

import com.xsis.xsis.dto.vac_prof_respro.ClientEmployeeDto;
import com.xsis.xsis.model.vac_prof_respro.Client;

/**
 * ClientServices
 */
public interface ClientServices {

    // Get List Data Client
    Iterable<Client> findAllClient();

    // Get List Data Client Join Employee
    Iterable<ClientEmployeeDto> getClientSelectOption();

}