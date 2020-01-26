package com.xsis.xsis.services.dhika.implementation;

import java.util.Optional;

import com.xsis.xsis.model.dhika.BiodataDika;
import com.xsis.xsis.repository.dhika.BiodataRepositoryDika;
import com.xsis.xsis.services.dhika.BiodataServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BiodataServicesImpl
 */
@Service
public class BiodataServicesImplDika implements BiodataServicesDika {

    @Autowired
    private BiodataRepositoryDika biodataRepository;

    @Override
    public Iterable<BiodataDika> getBiodata() {
        return biodataRepository.findAll();
    }

    @Override
    public Optional<BiodataDika> getBiodataById(Long id) {
        return biodataRepository.findById(id);
    }
}