package com.xsis.xsis.services.fathan.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.AddressBook;
import com.xsis.xsis.repository.fathan.AddrBookRepository;
import com.xsis.xsis.services.fathan.AddrBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AddrBookServiceImplement
 */
@Service
public class AddrBookServiceImplement implements AddrBookService {

    @Autowired
    private AddrBookRepository addrBookRepository;

    @Override
    public List<AddressBook> getAll() {
        List<AddressBook> ab = new ArrayList<>();
        for (AddressBook adb : addrBookRepository.findAll()) {
            if (!adb.getIsDelete()) {
                ab.add(adb);
            }
        }
        return ab;
    }

    @Override
    public Optional<AddressBook> getById(Long id) {
        return addrBookRepository.findById(id);
    }

    @Override
    public AddressBook save(AddressBook addressBook) {
        addressBook.setCreatedBy(9L);
        addressBook.setCreatedOn(new Date());
        addressBook.setIsDelete(false);
        addressBook.setIsLocked(false);
        addressBook.setAttempt(1);
        addressBook.setFpToken("-");
        addressBook.setFpExpiredDate(new Date());
        addressBook.setFpToken("-");
        addressBook.setFpCounter(1);
        return addrBookRepository.save(addressBook);
    }

    @Override
    public AddressBook delete(Long id) {
        AddressBook ad = addrBookRepository.findById(id).get();
        ad.setDeletedBy(9L);
        ad.setDeleteddOn(new Date());
        ad.setIsDelete(true);
        return addrBookRepository.save(ad);
    }

    @Override
    public Iterable<AddressBook> getLastAddrId() {
        return addrBookRepository.getLastAddrId();
    }

}