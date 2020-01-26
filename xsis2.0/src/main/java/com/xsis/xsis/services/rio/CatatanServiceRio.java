package com.xsis.xsis.services.rio;

import com.xsis.xsis.dto.rio.CatatanDtoRio;
import com.xsis.xsis.model.rio.CatatanEntityRio;
import com.xsis.xsis.repository.rio.CatatanRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CatatanServiceRio
{
    @Autowired
    private CatatanRepositoryRio catatanRepository;

    public Iterable<CatatanEntityRio> getCatatanEntity() {
        List<CatatanEntityRio> catatanEntities = new ArrayList<>();
        for(CatatanEntityRio catatanEntity : catatanRepository.findAll()){
            if(!catatanEntity.getIsDelete()){
                catatanEntities.add(catatanEntity);
            }
        }
        return catatanEntities;
    }

    public Optional<CatatanEntityRio> findCatatanById(Long catatanId)
    {
        return catatanRepository.findById(catatanId);
    }

    public CatatanEntityRio saveCatatan(CatatanEntityRio catatanEntity)
    {
        catatanEntity.setCreatedBy((long) 1);
        catatanEntity.setCreatedOn(new Date());
        return catatanRepository.save(catatanEntity);
    }

    public CatatanEntityRio updateCatatan(CatatanEntityRio catatanEntity)
    {
        CatatanEntityRio catatanDetail = catatanRepository.findById(catatanEntity.getId()).get();
        catatanDetail.setTitle(catatanEntity.getTitle());
        catatanDetail.setNoteTypeId(catatanEntity.getNoteTypeId());
        catatanDetail.setNotes(catatanEntity.getNotes());
        catatanDetail.setModifiedBy((long) 1);
        catatanDetail.setModifiedOn(new Date());
        return catatanRepository.save(catatanDetail);
    }

    public CatatanEntityRio hideCatatan(Long id)
    {
        CatatanEntityRio catatanEntity = catatanRepository.findById(id).get();
        catatanEntity.setDeletedBy((long) 1);
        catatanEntity.setDeleteddOn(new Date());
        catatanEntity.setIsDelete(true);
        return catatanRepository.save(catatanEntity);
    }

    public void deleteCatatan(Long catatanId)
    {
        catatanRepository.deleteById(catatanId);
    }

    public List<CatatanDtoRio> getBioId(int biodataId)
    {
        return catatanRepository.getBioId(biodataId);
    }
}
