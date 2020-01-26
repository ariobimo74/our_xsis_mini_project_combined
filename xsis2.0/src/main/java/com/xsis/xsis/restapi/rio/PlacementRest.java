package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.PlacementEntityRio;
import com.xsis.xsis.services.rio.PlacementServiceRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "rest/placement")
public class PlacementRest
{
    @Autowired
    private PlacementServiceRio placementService;

    @GetMapping
    public Iterable<PlacementEntityRio> findAll()
    {
        return placementService.getPlacementEntity();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> placementById(@PathVariable("id") Long id)
    {
        Optional<PlacementEntityRio> optionalPlacementEntity = placementService.findPlacementById(id);
        if(optionalPlacementEntity.isPresent())
        {
            return new ResponseEntity<>(optionalPlacementEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
