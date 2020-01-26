package com.xsis.xsis.restapi.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.TsAssessmentDtoAlfia;
import com.xsis.xsis.model.fia.TsAssessmentAlfia;
import com.xsis.xsis.services.fia.TsAssessmentServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/alfia/tsassessment")
public class TsAssessmentAPIAlfia {

    @Autowired
    private TsAssessmentServiceAlfia tsAssessmentService;

    @GetMapping
    public List<TsAssessmentAlfia> getAllTs() {
        return tsAssessmentService.getAll();
    }

    @PostMapping
    public TsAssessmentDtoAlfia saveTsAs(@RequestBody TsAssessmentDtoAlfia tsassessment) {
        TsAssessmentAlfia ts = new TsAssessmentAlfia();
        ts.setYear(tsassessment.getYear());
        ts.setMonth(tsassessment.getMonth());
        ts.setPlacementId(tsassessment.getPlacementId());
        ts.setTargetResult(tsassessment.getTargetResult());
        ts.setCompetencyCompetency(tsassessment.getCompetencyCompetency());
        ts.setDiscipline(tsassessment.getDiscipline());
        tsAssessmentService.save(ts);
        return tsassessment;
    }

}