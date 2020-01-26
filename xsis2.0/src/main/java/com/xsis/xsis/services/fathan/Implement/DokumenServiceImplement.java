package com.xsis.xsis.services.fathan.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.fathan.DokumenDto;
import com.xsis.xsis.model.fathan.Dokumen;
import com.xsis.xsis.repository.fathan.DokumenRepository;
import com.xsis.xsis.services.fathan.DokumenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DokumenServiceImplement
 */
@Service
public class DokumenServiceImplement implements DokumenService {

    @Autowired
    private DokumenRepository dokumenRepository;

    @Override
    public List<Dokumen> getAll() {
        List<Dokumen> dok = new ArrayList<>();
        for (Dokumen doku : dokumenRepository.findAll()) {
            if (!doku.getIsDelete()) {
                dok.add(doku);
            }
        }
        return dok;
    }

    @Override
    public Optional<Dokumen> getById(Long id) {
        return dokumenRepository.findById(id);
    }

    @Override // post
    public Dokumen saveFile(Dokumen dokumen) {
        dokumen.setCreatedBy(9L);
        dokumen.setCreatedOn(new Date());
        dokumen.setIsDelete(false);
        dokumen.setIsPhoto(false);
        dokumen.setFileName(dokumen.getFileName());
        dokumen.setFilePath(dokumen.getFilePath());
        return dokumenRepository.save(dokumen);
    }

    @Override // postfoto
    public Dokumen saveFoto(Dokumen dokumen) {
        dokumen.setCreatedBy(9L);
        dokumen.setCreatedOn(new Date());
        dokumen.setIsDelete(false);
        dokumen.setIsPhoto(true);
        dokumen.setFileName(dokumen.getFileName());
        dokumen.setFilePath(dokumen.getFilePath());
        return dokumenRepository.save(dokumen);
    }

    @Override // put
    public Dokumen edit(Dokumen dokumen) {
        Dokumen dok = dokumenRepository.findById(dokumen.getId()).get();
        dok.setModifiedBy(9L);
        dok.setModifiedOn(new Date());

        dok.setBiodataId(dokumen.getBiodataId());
        dok.setFileName(dokumen.getFileName());
        dok.setNotesDoc(dokumen.getNotesDoc());
        return dokumenRepository.save(dok);
    }

    @Override // delete
    public Dokumen delete(Long id) {
        Dokumen dok = dokumenRepository.findById(id).get();
        dok.setDeletedBy(9L);
        dok.setDeleteddOn(new Date());
        dok.setIsDelete(true);

        return dokumenRepository.save(dok);
    }

    @Override
    public List<DokumenDto> getBioId(Long biodataId) {
        return dokumenRepository.getBioId(biodataId);
    }

    @Override
    public Long getBiodataIdFile(Dokumen dokumen) {
        return dokumen.getBiodataId();
    }

}