package com.xsis.xsis.services.fathan.Implement;

import java.util.Date;
import java.util.Optional;

import com.xsis.xsis.model.fathan.BiodataFathan;
import com.xsis.xsis.repository.fathan.BiodataRepositoryFathan;
import com.xsis.xsis.services.fathan.BiodataServicesFathan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BiodataServicesImpl
 */
@Service
public class BiodataServicesImplFathan implements BiodataServicesFathan {

    @Autowired
    private BiodataRepositoryFathan biodataRepository;

    @Override
    public Iterable<BiodataFathan> getBiodata() {
        return biodataRepository.findAll();
    }

    @Override
    public Optional<BiodataFathan> getBiodataById(Long id) {
        return biodataRepository.findById(id);
    }

    @Override
    public BiodataFathan edit(BiodataFathan biodata) {
        BiodataFathan bio = biodataRepository.findById(biodata.getId()).get();
        bio.setModifiedBy(9L);
        bio.setModifiedOn(new Date());
        bio.setAddrbookId(biodata.getAddrbookId());
        return biodataRepository.save(bio);
    }

}