package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.ClientEntityRio;
import com.xsis.xsis.services.rio.ClientServiceRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "rest/client")
public class ClientRest
{
    @Autowired
    private ClientServiceRio clientService;

    @GetMapping
    public Iterable<ClientEntityRio> findAll()
    {
        return clientService.getClientEntity();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> clientById(@PathVariable("id") Long id)
    {
        Optional<ClientEntityRio> optionalClientEntity = clientService.findClientById(id);
        if(optionalClientEntity.isPresent())
        {
            return new ResponseEntity<>(optionalClientEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
