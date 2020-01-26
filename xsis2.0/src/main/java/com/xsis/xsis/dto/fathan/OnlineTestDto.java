package com.xsis.xsis.dto.fathan;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * OnlineTestDto
 */
public class OnlineTestDto {

    public Long id;
    public Boolean isdelete;
    public Long biodataId;
    public String periodeCode;
    public Integer period;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.DATE)
    public Date testDate;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.DATE)
    public Date expiredTest;
    
    public String userAccess;
    public String status;

    public OnlineTestDto(){

    }

    public OnlineTestDto(Long id, Boolean isdelete, Long biodataId, String periodeCode, Integer period, Date testDate,
            Date expiredTest, String userAccess, String status) {
        this.id = id;
        this.isdelete = isdelete;
        this.biodataId = biodataId;
        this.periodeCode = periodeCode;
        this.period = period;
        this.testDate = testDate;
        this.expiredTest = expiredTest;
        this.userAccess = userAccess;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Long getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public String getPeriodeCode() {
        return periodeCode;
    }

    public void setPeriodeCode(String periodeCode) {
        this.periodeCode = periodeCode;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Date getExpiredTest() {
        return expiredTest;
    }

    public void setExpiredTest(Date expiredTest) {
        this.expiredTest = expiredTest;
    }

    public String getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}