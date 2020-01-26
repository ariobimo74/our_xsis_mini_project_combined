package com.xsis.xsis.restapi.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.ClientnameDika;
import com.xsis.xsis.services.dhika.ClientNameServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientNameAPI
 */
@RestController
@RequestMapping(path = "api/client-name", produces = "application/json")
@CrossOrigin("*")
public class ClientNameAPIDika {

    @Autowired
    ClientNameServiceDika client;

    @GetMapping
    public List<ClientnameDika> getAll() {
        return client.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ClientnameDika> getById(@PathVariable("id") Long id) {

        return client.getById(id);

    }

}