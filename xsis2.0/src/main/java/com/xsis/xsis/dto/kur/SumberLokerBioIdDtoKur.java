package com.xsis.xsis.dto.kur;

import java.util.Date;

public class SumberLokerBioIdDtoKur {
    private Long id;
    private Boolean isDelete;
    private Date applyDate;
    private Long biodataId;
    private String candidateType;
    private String careerCenterName;
    private String eventName;
    private String lastIncome;
    private String otherSource;
    private String referrerEmail;
    private String referrerName;
    private String referrerPhone;
    private String vacancySource;

    public SumberLokerBioIdDtoKur(Long id, Boolean isDelete, Date applyDate, Long biodataId, String candidateType,
            String careerCenterName, String eventName, String lastIncome, String otherSource, String referrerEmail,
            String referrerName, String referrerPhone, String vacancySource) {
        this.id = id;
        this.isDelete = isDelete;
        this.applyDate = applyDate;
        this.biodataId = biodataId;
        this.candidateType = candidateType;
        this.careerCenterName = careerCenterName;
        this.eventName = eventName;
        this.lastIncome = lastIncome;
        this.otherSource = otherSource;
        this.referrerEmail = referrerEmail;
        this.referrerName = referrerName;
        this.referrerPhone = referrerPhone;
        this.vacancySource = vacancySource;
    }

    public SumberLokerBioIdDtoKur() {
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Boolean return the isDelete
     */
    public Boolean isIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete the isDelete to set
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return Date return the applyDate
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * @param applyDate the applyDate to set
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * @return Long return the biodataId
     */
    public Long getBiodataId() {
        return biodataId;
    }

    /**
     * @param biodataId the biodataId to set
     */
    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    /**
     * @return String return the candidateType
     */
    public String getCandidateType() {
        return candidateType;
    }

    /**
     * @param candidateType the candidateType to set
     */
    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    /**
     * @return String return the careerCenterName
     */
    public String getCareerCenterName() {
        return careerCenterName;
    }

    /**
     * @param careerCenterName the careerCenterName to set
     */
    public void setCareerCenterName(String careerCenterName) {
        this.careerCenterName = careerCenterName;
    }

    /**
     * @return String return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return String return the lastIncome
     */
    public String getLastIncome() {
        return lastIncome;
    }

    /**
     * @param lastIncome the lastIncome to set
     */
    public void setLastIncome(String lastIncome) {
        this.lastIncome = lastIncome;
    }

    /**
     * @return String return the otherSource
     */
    public String getOtherSource() {
        return otherSource;
    }

    /**
     * @param otherSource the otherSource to set
     */
    public void setOtherSource(String otherSource) {
        this.otherSource = otherSource;
    }

    /**
     * @return String return the referrerEmail
     */
    public String getReferrerEmail() {
        return referrerEmail;
    }

    /**
     * @param referrerEmail the referrerEmail to set
     */
    public void setReferrerEmail(String referrerEmail) {
        this.referrerEmail = referrerEmail;
    }

    /**
     * @return String return the referrerName
     */
    public String getReferrerName() {
        return referrerName;
    }

    /**
     * @param referrerName the referrerName to set
     */
    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName;
    }

    /**
     * @return String return the referrerPhone
     */
    public String getReferrerPhone() {
        return referrerPhone;
    }

    /**
     * @param referrerPhone the referrerPhone to set
     */
    public void setReferrerPhone(String referrerPhone) {
        this.referrerPhone = referrerPhone;
    }

    /**
     * @return String return the vacancySource
     */
    public String getVacancySource() {
        return vacancySource;
    }

    /**
     * @param vacancySource the vacancySource to set
     */
    public void setVacancySource(String vacancySource) {
        this.vacancySource = vacancySource;
    }

}