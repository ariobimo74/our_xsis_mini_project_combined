package com.xsis.xsis.services.fia.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.xsis.xsis.dto.fia.ReferensiBioDtoAlfia;
import com.xsis.xsis.model.fia.ReferensiAlfia;
import com.xsis.xsis.repository.fia.ReferensiRepositoryAlfia;
import com.xsis.xsis.services.fia.ReferensiServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ReferensiServiceImp
 */
@Service
@Transactional
public class ReferensiServiceImpAlfia implements ReferensiServiceAlfia {
    @Autowired
    private ReferensiRepositoryAlfia referensiRepository;

    @Override
    public ReferensiAlfia getById(Long id) {
        return referensiRepository.findById(id).get();
    }

    @Override
    public List<ReferensiAlfia> getAll() {
        List<ReferensiAlfia> ref = new ArrayList<>();
        for (ReferensiAlfia refs : referensiRepository.findAll()) {
            if (!refs.getIsDelete()) {
                ref.add(refs);
            }
        }
        return ref;
    }

    @Override
    public ReferensiAlfia save(ReferensiAlfia referensi) {
        referensi.setCreatedBy(2L);
        referensi.setCreatedOn(new Date());
        return referensiRepository.save(referensi);
    }

    @Override
    public ReferensiAlfia update(ReferensiAlfia referensi) {
        ReferensiAlfia refe = referensiRepository.findById(referensi.getId()).get();

        refe.setModifiedBy(2L);
        refe.setModifiedOn(new Date());

        refe.setBiodataId(referensi.getBiodataId());
        refe.setName(referensi.getName());
        refe.setPosition(referensi.getPosition());
        refe.setAddressPhone(referensi.getAddressPhone());
        refe.setRelation(referensi.getRelation());

        return referensiRepository.save(refe);
    }

    @Override
    public ReferensiAlfia delete(Long id) {
        ReferensiAlfia refe = referensiRepository.findById(id).get();
        refe.setIsDelete(true);
        refe.setDeletedBy(2L);
        refe.setDeleteddOn(new Date());
        return referensiRepository.save(refe);
    }

    @Override
    public List<ReferensiBioDtoAlfia> getBioId(Long biodataId) {
        return referensiRepository.getBioId(biodataId);
    }
}