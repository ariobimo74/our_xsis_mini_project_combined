package com.xsis.xsis.services.fia;

import java.util.List;

import com.xsis.xsis.model.fia.TsAssessmentAlfia;

/**
 * TsAssessmentService
 */
public interface TsAssessmentServiceAlfia {

    List<TsAssessmentAlfia> getAll();

    TsAssessmentAlfia save(TsAssessmentAlfia tsAssessment);
}