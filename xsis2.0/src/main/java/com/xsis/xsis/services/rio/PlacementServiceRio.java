package com.xsis.xsis.services.rio;

import com.xsis.xsis.model.rio.PlacementEntityRio;
import com.xsis.xsis.repository.rio.PlacementRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlacementServiceRio
{
    @Autowired
    private PlacementRepositoryRio placementRepository;

    public Iterable<PlacementEntityRio> getPlacementEntity()
    {
        List<PlacementEntityRio> placementEntities = new ArrayList<>();
        for (PlacementEntityRio placementEntity : placementRepository.findAll())
        {
            if (!placementEntity.getIsDelete())
            {
                placementEntities.add(placementEntity);
            }
        }
        return placementEntities;
    }

    public Optional<PlacementEntityRio> findPlacementById(Long placementId)
    {
        return placementRepository.findById(placementId);
    }
}
