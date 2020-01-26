package com.xsis.xsis.model.fia;

import javax.persistence.*;

import com.xsis.xsis.models.common.CommonEntity;

@Entity
@Table(name = "x_timesheet_assessment")
public class TsAssessmentAlfia extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "month", nullable = false)
    private Integer month;

    @Column(name = "placement_id", nullable = false)
    private Long placementId;

    @Column(name = "target_result", nullable = false)
    private Integer targetResult;

    @Column(name = "competency", nullable = false)
    private Integer competencyCompetency;

    @Column(name = "discipline", nullable = false)
    private Integer discipline;

    public TsAssessmentAlfia() {
    }

    public TsAssessmentAlfia(Integer year, Integer month, Long placementId, Integer targetResult,
            Integer competencyCompetency, Integer discipline) {
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