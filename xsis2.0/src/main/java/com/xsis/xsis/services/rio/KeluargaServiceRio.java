package com.xsis.xsis.services.rio;

import com.xsis.xsis.dto.rio.KeluargaDtoRio;
import com.xsis.xsis.model.rio.KeluargaEntityRio;
import com.xsis.xsis.repository.rio.KeluargaRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class KeluargaServiceRio
{
    @Autowired
    private KeluargaRepositoryRio keluargaRepository;

    public Iterable<KeluargaEntityRio> getkeluargaEntity() {
        List<KeluargaEntityRio> keluargaEntities = new ArrayList<>();
        for(KeluargaEntityRio keluargaEntity : keluargaRepository.findAll()){
            if(!keluargaEntity.getIsDelete()){
                keluargaEntities.add(keluargaEntity);
            }
        }
        return keluargaEntities;
    }

    public Optional<KeluargaEntityRio> findKeluargaById(Long keluargaId)
    {
        return keluargaRepository.findById(keluargaId);
    }

    public KeluargaEntityRio saveKeluarga(KeluargaEntityRio keluargaEntity)
    {
        keluargaEntity.setCreatedBy((long) 1);
        keluargaEntity.setCreatedOn(new Date());
        return keluargaRepository.save(keluargaEntity);
    }

    public KeluargaEntityRio updateKeluarga(KeluargaEntityRio keluargaEntity)
    {
        KeluargaEntityRio keluargaDetail = keluargaRepository.findById(keluargaEntity.getId()).get();
        keluargaDetail.setFamilyTreeTypeId(keluargaEntity.getFamilyTreeTypeId());
        keluargaDetail.setFamilyRelationId(keluargaEntity.getFamilyRelationId());
        keluargaDetail.setName(keluargaEntity.getName());
        keluargaDetail.setGender(keluargaEntity.getGender());
        keluargaDetail.setDob(keluargaEntity.getDob());
        keluargaDetail.setEducationLevelId(keluargaEntity.getEducationLevelId());
        keluargaDetail.setJob(keluargaEntity.getJob());
        keluargaDetail.setNotes(keluargaEntity.getNotes());
        keluargaDetail.setModifiedBy((long) 1);
        keluargaDetail.setModifiedOn(new Date());
        return keluargaRepository.save(keluargaDetail);
    }

    public KeluargaEntityRio hideKeluarga(Long id)
    {
        KeluargaEntityRio keluargaEntity = keluargaRepository.findById(id).get();
        keluargaEntity.setDeletedBy((long) 1);
        keluargaEntity.setDeleteddOn(new Date());
        keluargaEntity.setIsDelete(true);
        return keluargaRepository.save(keluargaEntity);
    }

    public void deleteCatatan(Long catatanId)
    {
        keluargaRepository.deleteById(catatanId);
    }

    public List<KeluargaDtoRio> getBioId(int biodataId)
    {
        return keluargaRepository.getBioId(biodataId);
    }
}
