package com.xsis.xsis.services.vac_prof_respro.implementation;

import com.xsis.xsis.dto.vac_prof_respro.ClientEmployeeDto;
import com.xsis.xsis.model.vac_prof_respro.Client;
import com.xsis.xsis.repository.vac_prof_respro.ClientRepository;
import com.xsis.xsis.services.vac_prof_respro.ClientServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClientServicesImpl
 */
@Service
public class ClientServicesImpl implements ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Iterable<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Iterable<ClientEmployeeDto> getClientSelectOption() {
        return clientRepository.getClientSelectOption();
    }

}