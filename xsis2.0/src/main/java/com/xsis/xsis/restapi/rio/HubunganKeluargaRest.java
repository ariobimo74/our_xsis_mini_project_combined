package com.xsis.xsis.restapi.rio;

import com.xsis.xsis.model.rio.HubunganKeluargaEntityRio;
import com.xsis.xsis.repository.rio.HubunganKeluargaRepositoryRio;
import com.xsis.xsis.services.rio.HubunganKeluargaServiceRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/hubungankeluarga")
public class HubunganKeluargaRest
{
    @Autowired
    private HubunganKeluargaRepositoryRio hubunganKeluargaRepository;

    @Autowired
    private HubunganKeluargaServiceRio hubunganKeluargaService;

    @GetMapping
    public Iterable<HubunganKeluargaEntityRio> findAllHubunganKeluarga()
    {
        return hubunganKeluargaRepository.findAll();
    }

    @GetMapping("/tipe/{family_tree_type_id}")
    public ResponseEntity<?> findTipeId(@PathVariable("family_tree_type_id") Long familyTreeTypeId)
    {
        return new ResponseEntity<>(hubunganKeluargaService.getTipeId(familyTreeTypeId), HttpStatus.OK);
    }
}
