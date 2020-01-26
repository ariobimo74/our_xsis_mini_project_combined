package com.xsis.xsis.model.fia;

import javax.persistence.*;

import com.xsis.xsis.dto.fia.KeteranganBioDtoAlfia;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "keteranganAlfiaMapping", classes = {
        @ConstructorResult(targetClass = KeteranganBioDtoAlfia.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "biodata_id", type = Long.class),
                @ColumnResult(name = "expected_salary", type = String.class),
                @ColumnResult(name = "is_negotiable", type = Boolean.class),
                @ColumnResult(name = "start_working", type = String.class),
                @ColumnResult(name = "is_ready_to_outoftown", type = Boolean.class),
                @ColumnResult(name = "emergency_contact_name", type = String.class),
                @ColumnResult(name = "emergency_contact_phone", type = String.class), }) })

@NamedNativeQuery(name = "KeteranganAlfia.getBioId", query = "select a.id,a.isdelete,a.biodata_id,a.expected_salary,a.is_negotiable,a.start_working,a.is_ready_to_outoftown,a.emergency_contact_name,a.emergency_contact_phone"
        + " from x_keterangan_tambahan a where a.biodata_id=:biodataId and a.isdelete=false", resultSetMapping = "keteranganAlfiaMapping")

@Entity
@Table(name = "x_keterangan_tambahan")
public class KeteranganAlfia extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private Long biodataId;

    @Column(name = "emergency_contact_name")
    private String emergencyContactName;

    @Column(name = "emergency_contact_phone")
    private String emergencyContactPhone;

    @Column(name = "expected_salary")
    private String expectedSalary;

    @Column(name = "is_negotiable")
    private Boolean isNegotiable;

    @Column(name = "start_working")
    private String startWorking;

    @Column(name = "is_ready_to_outoftown")
    private Boolean isReadyToOutoftown;

    @Column(name = "is_apply_other_place")
    private Boolean isApplyOtherPlace;

    @Column(name = "apply_place")
    private String applyPlace;

    @Column(name = "selection_phase")
    private String selectionPhase;

    @Column(name = "is_ever_badly_sick")
    private Boolean isEverBadlySick;

    @Column(name = "disease_name")
    private String diseaseName;

    @Column(name = "disease_time")
    private String diseaseTime;

    @Column(name = "is_ever_psychotest")
    private Boolean isEverPsychotest;

    @Column(name = "psychotest_needs")
    private String psychotestNeeds;

    @Column(name = "psychotest_time")
    private String psychotestTime;

    @Column(name = "requirementes_required")
    private String requirementesRequired;

    @Column(name = "other_notes")
    private String otherNotes;

    public KeteranganAlfia() {
    }

    public KeteranganAlfia(Long biodataId, String emergencyContactName, String emergencyContactPhone,
            String expectedSalary, Boolean isNegotiable, String startWorking, Boolean isReadyToOutoftown,
            Boolean isApplyOtherPlace, String applyPlace, String selectionPhase, Boolean isEverBadlySick,
            String diseaseName, String diseaseTime, Boolean isEverPsychotest, String psychotestNeeds,
            String psychotestTime, String requirementesRequired, String otherNotes) {
        this.biodataId = biodataId;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
        this.expectedSalary = expectedSalary;
        this.isNegotiable = isNegotiable;
        this.startWorking = startWorking;
        this.isReadyToOutoftown = isReadyToOutoftown;
        this.isApplyOtherPlace = isApplyOtherPlace;
        this.applyPlace = applyPlace;
        this.selectionPhase = selectionPhase;
        this.isEverBadlySick = isEverBadlySick;
        this.diseaseName = diseaseName;
        this.diseaseTime = diseaseTime;
        this.isEverPsychotest = isEverPsychotest;
        this.psychotestNeeds = psychotestNeeds;
        this.psychotestTime = psychotestTime;
        this.requirementesRequired = requirementesRequired;
        this.otherNotes = otherNotes;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBiodataId() {
        return this.biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public String getEmergencyContactName() {
        return this.emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return this.emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getExpectedSalary() {
        return this.expectedSalary;
    }

    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public Boolean isIsNegotiable() {
        return this.isNegotiable;
    }

    public Boolean getIsNegotiable() {
        return this.isNegotiable;
    }

    public void setIsNegotiable(Boolean isNegotiable) {
        this.isNegotiable = isNegotiable;
    }

    public String getStartWorking() {
        return this.startWorking;
    }

    public void setStartWorking(String startWorking) {
        this.startWorking = startWorking;
    }

    public Boolean isIsReadyToOutoftown() {
        return this.isReadyToOutoftown;
    }

    public Boolean getIsReadyToOutoftown() {
        return this.isReadyToOutoftown;
    }

    public void setIsReadyToOutoftown(Boolean isReadyToOutoftown) {
        this.isReadyToOutoftown = isReadyToOutoftown;
    }

    public Boolean isIsApplyOtherPlace() {
        return this.isApplyOtherPlace;
    }

    public Boolean getIsApplyOtherPlace() {
        return this.isApplyOtherPlace;
    }

    public void setIsApplyOtherPlace(Boolean isApplyOtherPlace) {
        this.isApplyOtherPlace = isApplyOtherPlace;
    }

    public String getApplyPlace() {
        return this.applyPlace;
    }

    public void setApplyPlace(String applyPlace) {
        this.applyPlace = applyPlace;
    }

    public String getSelectionPhase() {
        return this.selectionPhase;
    }

    public void setSelectionPhase(String selectionPhase) {
        this.selectionPhase = selectionPhase;
    }

    public Boolean isIsEverBadlySick() {
        return this.isEverBadlySick;
    }

    public Boolean getIsEverBadlySick() {
        return this.isEverBadlySick;
    }

    public void setIsEverBadlySick(Boolean isEverBadlySick) {
        this.isEverBadlySick = isEverBadlySick;
    }

    public String getDiseaseName() {
        return this.diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseTime() {
        return this.diseaseTime;
    }

    public void setDiseaseTime(String diseaseTime) {
        this.diseaseTime = diseaseTime;
    }

    public Boolean isIsEverPsychotest() {
        return this.isEverPsychotest;
    }

    public Boolean getIsEverPsychotest() {
        return this.isEverPsychotest;
    }

    public void setIsEverPsychotest(Boolean isEverPsychotest) {
        this.isEverPsychotest = isEverPsychotest;
    }

    public String getPsychotestNeeds() {
        return this.psychotestNeeds;
    }

    public void setPsychotestNeeds(String psychotestNeeds) {
        this.psychotestNeeds = psychotestNeeds;
    }

    public String getPsychotestTime() {
        return this.psychotestTime;
    }

    public void setPsychotestTime(String psychotestTime) {
        this.psychotestTime = psychotestTime;
    }

    public String getRequirementesRequired() {
        return this.requirementesRequired;
    }

    public void setRequirementesRequired(String requirementesRequired) {
        this.requirementesRequired = requirementesRequired;
    }

    public String getOtherNotes() {
        return this.otherNotes;
    }

    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }

}