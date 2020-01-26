package com.xsis.xsis.services.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.PlacementDika;

/**
 * PlacementService
 */
public interface PlacementServiceDika {

    List<PlacementDika> getAll();

    Optional<PlacementDika> getById(Long id);

}