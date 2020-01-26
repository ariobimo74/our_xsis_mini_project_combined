package com.xsis.xsis.restapi.kur;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.kur.RencanaDetailKur;
import com.xsis.xsis.services.kur.RencanaDetailServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RencanaDetailAPI
 */
@RestController
@RequestMapping(path = "/api/rencana-detail-ku", produces = "application/json")
@CrossOrigin(origins = "*")
public class RencanaDetailAPIKur {

    @Autowired
    private RencanaDetailServiceKur rencanaDetailServiceKur;

    @GetMapping
    public List<RencanaDetailKur> getAllData() {
        return rencanaDetailServiceKur.getRencanDetailAll();
    }

    @GetMapping("/{id}")
    public RencanaDetailKur getByIdData(@PathVariable(value = "id") Long id) {
        return rencanaDetailServiceKur.getById(id);
    }

    @GetMapping("/get/{rencana_id}")
    public List<RencanaDetailKur> getBioRoTro(@PathVariable(value = "rencana_id") Long rencanaId) {
        return rencanaDetailServiceKur.getRencanaId(rencanaId);
    }

    @GetMapping("/get/{rencana_id}/{biodata_id}")
    public Optional<RencanaDetailKur> getBioAndRencaId(@PathVariable(value = "rencana_id") Long rencanaId,
            @PathVariable(value = "biodata_id") Long biodataId) {
        return rencanaDetailServiceKur.getRencanaByIddanRencanaId(rencanaId, biodataId);
    }

}