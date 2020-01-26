package com.xsis.xsis.model.kur;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.dto.kur.SumberLokerBioIdDtoKur;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "sumberlokerMapping", classes = {
        @ConstructorResult(targetClass = SumberLokerBioIdDtoKur.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "apply_date", type = Date.class),
                @ColumnResult(name = "biodata_id", type = Long.class),
                @ColumnResult(name = "candidate_type", type = String.class),
                @ColumnResult(name = "career_center_name", type = String.class),
                @ColumnResult(name = "event_name", type = String.class),
                @ColumnResult(name = "last_income", type = String.class),
                @ColumnResult(name = "other_source", type = String.class),
                @ColumnResult(name = "referrer_email", type = String.class),
                @ColumnResult(name = "referrer_name", type = String.class),
                @ColumnResult(name = "referrer_phone", type = String.class),
                @ColumnResult(name = "vacancy_source", type = String.class) }) })

// List Category Join Brand
@NamedNativeQuery(name = "SumberLokerKur.getBioSumberLokerId", query = "select a.id,a.isdelete,a.apply_date,a.biodata_id,a.candidate_type,a.career_center_name,a.event_name,a.last_income,a.other_source,a.referrer_email,a.referrer_name,a.referrer_phone,a.vacancy_source"
        + " from x_sumber_loker a where a.biodata_id=:biodataId and isdelete=false", resultSetMapping = "sumberlokerMapping")

@Entity
@Table(name = "x_sumber_loker")
public class SumberLokerKur extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private Long biodataId;

    @Column(name = "vacancy_source")
    @Size(max = 20)
    private String vacancySource;

    @Column(name = "candidate_type")
    @Size(max = 10)
    private String candidateType;

    @Column(name = "event_name")
    @Size(max = 100)
    private String eventName;

    @Column(name = "career_center_name")
    @Size(max = 100)
    private String careerCenterName;

    @Column(name = "referrer_name")
    @Size(max = 100)
    private String referrerName;

    @Column(name = "referrer_phone")
    @Size(max = 20)
    private String referrerPhone;

    @Column(name = "referrer_email")
    @Size(max = 100)
    private String referrerEmail;

    @Column(name = "other_source")
    @Size(max = 100)
    private String otherSource;

    @Column(name = "last_income")
    @Size(max = 20)
    private String lastIncome;

    @Column(name = "apply_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyDate;

    public SumberLokerKur() {
    }

    public SumberLokerKur(Long biodataId, String vacancySource, String candidateType, String eventName,
            String careerCenterName, String referrerName, String referrerPhone, String referrerEmail,
            String otherSource, String lastIncome, Date applyDate) {
        this.biodataId = biodataId;
        this.vacancySource = vacancySource;
        this.candidateType = candidateType;
        this.eventName = eventName;
        this.careerCenterName = careerCenterName;
        this.referrerName = referrerName;
        this.referrerPhone = referrerPhone;
        this.referrerEmail = referrerEmail;
        this.otherSource = otherSource;
        this.lastIncome = lastIncome;
        this.applyDate = applyDate;
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

}