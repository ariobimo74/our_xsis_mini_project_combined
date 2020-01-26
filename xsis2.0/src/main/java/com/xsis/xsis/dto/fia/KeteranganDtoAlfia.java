package com.xsis.xsis.dto.fia;

/**
 * KeteranganDto
 */
public class KeteranganDtoAlfia {

    private Long id;
    private Long biodataId;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String expectedSalary;
    private Boolean isNegotiable;
    private String startWorking;
    private Boolean isReadyToOutoftown;
    private Boolean isApplyOtherPlace;
    private String applyPlace;
    private String selectionPhase;
    private Boolean isEverBadlySick;
    private String diseaseName;
    private String diseaseTime;
    private Boolean isEverPsychotest;
    private String psychotestNeeds;
    private String psychotestTime;
    private String requirementesRequired;
    private String otherNotes;

    public KeteranganDtoAlfia(Long id, Long biodataId, String emergencyContactName, String emergencyContactPhone,
            String expectedSalary, Boolean isNegotiable, String startWorking, Boolean isReadyToOutoftown,
            Boolean isApplyOtherPlace, String applyPlace, String selectionPhase, Boolean isEverBadlySick,
            String diseaseName, String diseaseTime, Boolean isEverPsychotest, String psychotestNeeds,
            String psychotestTime, String requirementesRequired, String otherNotes) {
        this.id = id;
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