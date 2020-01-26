package com.xsis.xsis.restapi.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.AddressBook;
import com.xsis.xsis.services.fathan.AddrBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * AddrBookAPI
 */
@RestController
@RequestMapping(path = "api/addressBook")
public class AddrBookAPI {
    @Autowired
    private AddrBookService addrBookService;

    @GetMapping("/")
    public List<AddressBook> getAll() {
        return addrBookService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AddressBook> getById(@PathVariable(value = "id") Long id) {
        return addrBookService.getById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressBook addAddrBook(@RequestBody AddressBook addressBook) {
        return addrBookService.save(addressBook);
    }

    @DeleteMapping(path = "/{id}")
    public AddressBook deleteAddrBook(@PathVariable("id") Long id) {
        return addrBookService.delete(id);
    }

    @GetMapping("/lastId")
    public Iterable<AddressBook> getLastId() {
        return addrBookService.getLastAddrId();
    }
}