package com.xsis.xsis.services.dhika;

import java.util.*;

import com.xsis.xsis.model.dhika.ReligionDika;

/**
 * ReligionServices
 */
public interface ReligionServicesDika {

    Iterable<ReligionDika> findAll();

    Iterable<ReligionDika> searchByName(String name);

    Optional<ReligionDika> getById(Long id);

    ReligionDika save(ReligionDika religion);

    ReligionDika update(ReligionDika religion);

    ReligionDika delete(Long id);

}