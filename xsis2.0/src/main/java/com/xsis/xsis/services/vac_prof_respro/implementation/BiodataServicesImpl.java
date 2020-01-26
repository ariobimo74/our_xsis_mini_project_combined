package com.xsis.xsis.services.vac_prof_respro.implementation;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.vac_prof_respro.Biodata;
import com.xsis.xsis.repository.vac_prof_respro.BiodataRepository;
import com.xsis.xsis.services.vac_prof_respro.BiodataServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BiodataServicesImpl
 */
@Service
public class BiodataServicesImpl implements BiodataServices {

    @Autowired
    private BiodataRepository biodataRepository;

    @Override
    public Iterable<Biodata> getBiodata() {
        return biodataRepository.findAll();
    }

    @Override
    public Optional<Biodata> getBiodataById(Long id) {
        return biodataRepository.findById(id);
    }

    @Override
    public List<Biodata> getPelamar(String pelamar) {
        return biodataRepository.getPelamar(pelamar);
    }
}