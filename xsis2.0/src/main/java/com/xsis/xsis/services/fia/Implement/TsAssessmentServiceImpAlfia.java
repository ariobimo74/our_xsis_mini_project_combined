package com.xsis.xsis.services.fia.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.xsis.xsis.model.fia.TsAssessmentAlfia;
import com.xsis.xsis.repository.fia.TsAssessmentRepositoryAlfia;
import com.xsis.xsis.services.fia.TsAssessmentServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TsAssessmentServiceImpAlfia implements TsAssessmentServiceAlfia {
    @Autowired
    private TsAssessmentRepositoryAlfia tsAssessmentRepository;

    @Override
    public List<TsAssessmentAlfia> getAll() {
        List<TsAssessmentAlfia> ts = new ArrayList<>();
        for (TsAssessmentAlfia tss : tsAssessmentRepository.findAll()) {
            if (!tss.getIsDelete()) {
                ts.add(tss);
            }
        }
        return ts;
    }

    @Override
    public TsAssessmentAlfia save(TsAssessmentAlfia tsAssessment) {
        tsAssessment.setCreatedBy(2L);
        tsAssessment.setCreatedOn(new Date());
        return tsAssessmentRepository.save(tsAssessment);
    }

}