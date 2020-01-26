package com.xsis.xsis.services.dhika;

import java.util.*;

import com.xsis.xsis.model.dhika.ClientDika;

/**
 * ClientService
 */
public interface ClientServiceDika {

    List<ClientDika> getAll();

    Optional<ClientDika> getById(Long id);

}