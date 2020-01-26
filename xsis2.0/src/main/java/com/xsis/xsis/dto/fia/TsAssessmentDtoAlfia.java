package com.xsis.xsis.dto.fia;

public class TsAssessmentDtoAlfia {

    private Long id;
    private Integer year;
    private Integer month;
    private Long placementId;
    private Integer targetResult;
    private Integer competencyCompetency;
    private Integer discipline;

    public TsAssessmentDtoAlfia(Long id, Integer year, Integer month, Long placementId, Integer targetResult,
            Integer competencyCompetency, Integer discipline) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.placementId = placementId;
        this.targetResult = targetResult;
        this.competencyCompetency = competencyCompetency;
        this.discipline = discipline;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return this.month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Long getPlacementId() {
        return this.placementId;
    }

    public void setPlacementId(Long placementId) {
        this.placementId = placementId;
    }

    public Integer getTargetResult() {
        return this.targetResult;
    }

    public void setTargetResult(Integer targetResult) {
        this.targetResult = targetResult;
    }

    public Integer getCompetencyCompetency() {
        return this.competencyCompetency;
    }

    public void setCompetencyCompetency(Integer competencyCompetency) {
        this.competencyCompetency = competencyCompetency;
    }

    public Integer getDiscipline() {
        return this.discipline;
    }

    public void setDiscipline(Integer discipline) {
        this.discipline = discipline;
    }
}