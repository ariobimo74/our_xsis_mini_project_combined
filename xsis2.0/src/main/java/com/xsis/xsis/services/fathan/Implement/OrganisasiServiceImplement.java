package com.xsis.xsis.services.fathan.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.fathan.OrganisasiDto;
import com.xsis.xsis.model.fathan.Organisasi;
import com.xsis.xsis.repository.fathan.OrganisasiRepository;
import com.xsis.xsis.services.fathan.OrganisasiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrganisasiServiceImplement
 */
@Service
public class OrganisasiServiceImplement implements OrganisasiService {

    @Autowired
    private OrganisasiRepository organisasiRepository;

    @Override
    public List<Organisasi> getAll() {
        List<Organisasi> org = new ArrayList<>();
        for (Organisasi orgs : organisasiRepository.findAll()) {
            if (!orgs.getIsDelete()) {
                org.add(orgs);
            }

        }
        return org;
    }

    @Override
    public Optional<Organisasi> getById(Long id) {
        return organisasiRepository.findById(id);
    }

    @Override
    public Organisasi save(Organisasi organisasi) {

        organisasi.setCreatedBy(9L);
        organisasi.setCreatedOn(new Date());
        organisasi.setIsDelete(false);
        return organisasiRepository.save(organisasi);
    }

    @Override
    public Organisasi edit(Organisasi organisasi) {
        Organisasi org = organisasiRepository.findById(organisasi.getId()).get();
        // common
        org.setModifiedBy(9L);
        org.setModifiedOn(new Date());
        // entity
        org.setId(organisasi.getId());
        org.setBiodataId(organisasi.getBiodataId());
        org.setName(organisasi.getName());
        org.setPosition(organisasi.getPosition());
        org.setEntryYear(organisasi.getEntryYear());
        org.setExitYear(organisasi.getExitYear());
        org.setResponsibility(organisasi.getResponsibility());
        org.setNotes(organisasi.getNotes());
        return organisasiRepository.save(org);
    }

    @Override
    public Organisasi delete(Long id) {
        Organisasi org = organisasiRepository.findById(id).get();
        org.setIsDelete(true);
        org.setDeletedBy(9L);
        org.setDeleteddOn(new Date());

        return organisasiRepository.save(org);
    }

    @Override
    public List<OrganisasiDto> getBioId(Long biodataId) {
        return organisasiRepository.getBioId(biodataId);
    }

}