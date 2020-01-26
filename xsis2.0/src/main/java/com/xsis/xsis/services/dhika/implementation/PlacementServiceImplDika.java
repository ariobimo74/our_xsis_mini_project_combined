package com.xsis.xsis.services.dhika.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.PlacementDika;
import com.xsis.xsis.repository.dhika.PlacementRepositoryDika;
import com.xsis.xsis.services.dhika.PlacementServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PlacementServiceImpl
 */
@Service
public class PlacementServiceImplDika implements PlacementServiceDika {

    @Autowired
    private PlacementRepositoryDika placementRepository;

    @Override
    public List<PlacementDika> getAll() {
        List<PlacementDika> placement = new ArrayList<>();
        for (PlacementDika placements : placementRepository.getAll()) {
            if (!placements.getIsDelete()) {
                placement.add(placements);
            }
        }
        return placement;
    }

    @Override
    public Optional<PlacementDika> getById(Long id) {
        return placementRepository.findById(id);
    }

}