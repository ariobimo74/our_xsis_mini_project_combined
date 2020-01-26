package com.xsis.xsis.services.dhika;

import java.util.*;

import com.xsis.xsis.model.dhika.ClientnameDika;

/**
 * ClientNameService
 */

public interface ClientNameServiceDika {

    List<ClientnameDika> getAll();

    Optional<ClientnameDika> getById(Long id);

}