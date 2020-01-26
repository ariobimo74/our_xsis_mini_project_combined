package com.xsis.xsis.repository.fathan;

import com.xsis.xsis.model.fathan.AddressBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * AddrBookRepository
 */
@Repository
public interface AddrBookRepository extends JpaRepository<AddressBook, Long> {

    @Query(value = "select * from x_addrbook where isdelete=false order by created_on Desc limit 1", nativeQuery = true)
    Iterable<AddressBook> getLastAddrId();
}