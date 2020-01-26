package com.xsis.xsis.services.dhika.implementation;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.ClientnameDika;
import com.xsis.xsis.repository.dhika.ClientNameRepositoryDika;
import com.xsis.xsis.services.dhika.ClientNameServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClientNameServiceImpl
 */
@Service
public class ClientNameServiceImplDika implements ClientNameServiceDika {

    @Autowired
    private ClientNameRepositoryDika client;

    @Override
    public List<ClientnameDika> getAll() {
        return client.findAll();
    }

    @Override
    public Optional<ClientnameDika> getById(Long id) {
        return client.findById(id);
    }

}