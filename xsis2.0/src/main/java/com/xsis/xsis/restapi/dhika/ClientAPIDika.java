package com.xsis.xsis.restapi.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.ClientDika;
import com.xsis.xsis.services.dhika.ClientServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientAPI
 */
@RestController
@RequestMapping(path = "api/client-dika", produces = "application/json")
@CrossOrigin("*")
public class ClientAPIDika {

    @Autowired
    ClientServiceDika clientService;

    @GetMapping
    public List<ClientDika> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        Optional<ClientDika> optReg = clientService.getById(id);
        if (optReg.isPresent()) {
            return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}