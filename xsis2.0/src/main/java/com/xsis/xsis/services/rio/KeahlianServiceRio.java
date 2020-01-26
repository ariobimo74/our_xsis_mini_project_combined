package com.xsis.xsis.services.rio;

import com.xsis.xsis.dto.rio.KeahlianDtoRio;
import com.xsis.xsis.model.rio.KeahlianEntityRio;
import com.xsis.xsis.repository.rio.KeahlianRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KeahlianServiceRio {
    @Autowired
    private KeahlianRepositoryRio keahlianRepository;

    public Iterable<KeahlianEntityRio> getKeahlianEntity() {
        List<KeahlianEntityRio> keahlianEntities = new ArrayList<>();
        for (KeahlianEntityRio keahlianEntity : keahlianRepository.findAll()) {
            if (!keahlianEntity.getIsDelete()) {
                keahlianEntities.add(keahlianEntity);
            }
        }
        return keahlianEntities;
    }

    public Optional<KeahlianEntityRio> findKeahlianById(Long keahlianId) {
        return keahlianRepository.findById(keahlianId);
    }

    public KeahlianEntityRio saveKeahlian(KeahlianEntityRio keahlianEntity) {
        keahlianEntity.setCreatedBy((long) 1);
        keahlianEntity.setCreatedOn(new Date());
        return keahlianRepository.save(keahlianEntity);
    }

    public KeahlianEntityRio updateKeahlian(KeahlianEntityRio keahlianEntity) {
        KeahlianEntityRio keahlianDetail = keahlianRepository.findById(keahlianEntity.getId()).get();
        keahlianDetail.setSkillName(keahlianEntity.getSkillName());
        keahlianDetail.setSkillLevelId(keahlianEntity.getSkillLevelId());
        keahlianDetail.setNotes((keahlianEntity.getNotes()));
        keahlianDetail.setModifiedBy((long) 1);
        keahlianDetail.setModifiedOn(new Date());
        return keahlianRepository.save(keahlianDetail);
    }

    public KeahlianEntityRio hideKeahlian(Long id) {
        KeahlianEntityRio keahlianEntity = keahlianRepository.findById(id).get();
        keahlianEntity.setDeletedBy((long) 1);
        keahlianEntity.setDeleteddOn(new Date());
        keahlianEntity.setIsDelete(true);
        return keahlianRepository.save(keahlianEntity);
    }

    public void deleteKeahlian(Long keahlianId) {
        keahlianRepository.deleteById(keahlianId);
    }

    public List<KeahlianDtoRio> getBioId(Long biodataId) {
        return keahlianRepository.getBioId(biodataId);
    }
}
