package com.xsis.xsis.services.dhika.implementation;

import java.util.*;

import com.xsis.xsis.model.dhika.ClientDika;
import com.xsis.xsis.repository.dhika.ClientRepositoryDika;
import com.xsis.xsis.services.dhika.ClientServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClientServiceImpl
 */
@Service
public class ClientServiceImplDika implements ClientServiceDika {

    @Autowired
    private ClientRepositoryDika clientRepository;

    @Override
    public List<ClientDika> getAll() {

        List<ClientDika> client = new ArrayList<>();
        for (ClientDika clients : clientRepository.findAll()) {
            if (!clients.getIsDelete()) {
                client.add(clients);
            }
        }
        return client;

    }

    @Override
    public Optional<ClientDika> getById(Long id) {
        return clientRepository.findById(id);
    }

}