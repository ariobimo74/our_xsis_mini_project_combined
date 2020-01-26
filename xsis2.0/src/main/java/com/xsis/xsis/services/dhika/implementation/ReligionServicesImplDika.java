package com.xsis.xsis.services.dhika.implementation;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsis.xsis.model.dhika.ReligionDika;
import com.xsis.xsis.repository.dhika.ReligionRepositoryDika;
import com.xsis.xsis.services.dhika.ReligionServicesDika;

/**
 * ReligionServicesImpl
 */
@Service
@Transactional
public class ReligionServicesImplDika implements ReligionServicesDika {

    @Autowired
    private ReligionRepositoryDika religionRepository;

    @Override
    public Iterable<ReligionDika> findAll() {
        return religionRepository.getReligionAll();
    }

    @Override
    public Iterable<ReligionDika> searchByName(String name) {
        return religionRepository.findByName(name);
    }

    @Override
    public Optional<ReligionDika> getById(Long id) {
        return religionRepository.findById(id);
    }

    @Override
    public ReligionDika save(ReligionDika religion) {
        religion.setCreatedBy(2L);
        religion.setCreatedOn(new Date());
        religion.setIsDelete(false);
        return religionRepository.save(religion);
    }

    @Override
    public ReligionDika update(ReligionDika religion) {
        ReligionDika religionDetail = religionRepository.findById(religion.getId()).get();
        religionDetail.setName(religion.getName());
        religionDetail.setDescription(religion.getDescription());
        religionDetail.setModifiedBy(2L);
        religionDetail.setModifiedOn(new Date());
        return religionRepository.save(religionDetail);
    }

    @Override
    public ReligionDika delete(Long id) {
        ReligionDika religionEntity = religionRepository.findById(id).get();
        religionEntity.setIsDelete(true);
        religionEntity.setDeletedBy(2L);
        religionEntity.setDeleteddOn(new Date());
        return religionRepository.save(religionEntity);
    }

}