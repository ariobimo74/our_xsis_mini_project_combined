package com.xsis.xsis.repository.dhika;

import java.util.*;

import com.xsis.xsis.model.dhika.ReligionDika;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * ReligionRepository
 */

@Repository
public interface ReligionRepositoryDika extends PagingAndSortingRepository<ReligionDika, Long> {

    @Query("SELECT r FROM ReligionDika r WHERE r.isDelete=false ORDER BY r.name")
    List<ReligionDika> getReligionAll();

    @Query("SELECT r FROM ReligionDika r WHERE r.isDelete = FALSE AND LOWER(r.name) LIKE LOWER(CONCAT('%', ?1,'%'))")
    Iterable<ReligionDika> findByName(String name);

    // @Query("SELECT r FROM Religion r WHERE r.isDelete = FALSE AND LOWER(r.name)
    // LIKE LOWER(CONCAT('%', ?1,'%'))")

}