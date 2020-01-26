package com.xsis.xsis.services.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.AddressBook;

/**
 * AddrBookService
 */
public interface AddrBookService {

    List<AddressBook> getAll();

    Optional<AddressBook> getById(Long id);

    AddressBook save(AddressBook addressBook);

    AddressBook delete(Long id);

    Iterable<AddressBook> getLastAddrId();
}