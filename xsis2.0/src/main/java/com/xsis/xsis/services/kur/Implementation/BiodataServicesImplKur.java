package com.xsis.xsis.services.kur.Implementation;

import java.util.Optional;

import com.xsis.xsis.model.kur.BiodataKur;
import com.xsis.xsis.repository.kur.BiodataRepositoryKur;
import com.xsis.xsis.services.kur.BiodataServicesKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BiodataServicesImpl
 */
@Service
public class BiodataServicesImplKur implements BiodataServicesKur {

    @Autowired
    private BiodataRepositoryKur biodataRepositoryKur;

    @Override
    public Iterable<BiodataKur> getBiodata() {
        return biodataRepositoryKur.findAll();
    }

    @Override
    public Optional<BiodataKur> getBiodataById(Long id) {
        return biodataRepositoryKur.findById(id);
    }
}