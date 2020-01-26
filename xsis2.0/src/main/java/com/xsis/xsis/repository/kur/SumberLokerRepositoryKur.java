package com.xsis.xsis.repository.kur;

import java.util.List;

import com.xsis.xsis.dto.kur.SumberLokerBioIdDtoKur;
import com.xsis.xsis.model.kur.SumberLokerKur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SumberLokerRepositoryKur extends JpaRepository<SumberLokerKur, Long> {
    @Query(nativeQuery = true)
    List<SumberLokerBioIdDtoKur> getBioSumberLokerId(Long biodataId);
}