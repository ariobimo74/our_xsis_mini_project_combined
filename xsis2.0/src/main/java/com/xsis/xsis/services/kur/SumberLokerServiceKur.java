package com.xsis.xsis.services.kur;

import java.util.List;

import com.xsis.xsis.dto.kur.SumberLokerBioIdDtoKur;
import com.xsis.xsis.model.kur.SumberLokerKur;

public interface SumberLokerServiceKur {

    List<SumberLokerKur> getAll();

    List<SumberLokerBioIdDtoKur> getBioId(Long biodataId);

    SumberLokerKur save(SumberLokerKur sumberLoker);

    SumberLokerKur update(SumberLokerKur sumberLoker);

    SumberLokerKur getById(Long id);

}