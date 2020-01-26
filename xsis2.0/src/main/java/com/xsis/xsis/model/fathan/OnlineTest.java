package com.xsis.xsis.model.fathan;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.dto.fathan.OnlineTestDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "onlineTestMapping", classes = {
        @ConstructorResult(targetClass = OnlineTestDto.class, columns = { @ColumnResult(name = "id", type = Long.class),
                @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "biodata_id", type = Long.class),
                @ColumnResult(name = "period_code", type = String.class),
                @ColumnResult(name = "period", type = Integer.class),
                @ColumnResult(name = "test_date", type = Date.class),
                @ColumnResult(name = "expired_test", type = Date.class),
                @ColumnResult(name = "user_access", type = String.class),
                @ColumnResult(name = "status", type = String.class) }) })

@NamedNativeQuery(name = "OnlineTest.getBioId", query = "select id,isdelete,biodata_id,period_code,period,test_date,expired_test,user_access,status"
        + " from x_online_test where biodata_id=:biodataId and isdelete=false", resultSetMapping = "onlineTestMapping")
/**
 * OnlineTest
 */
@Entity
@Table(name = "x_online_test")
public class OnlineTest extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "period_code")
    private String periodeCode;

    @Column(name = "period")
    private Integer period;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.DATE)
    @Column(name = "test_date")
    private Date testDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.DATE)
    @Column(name = "expired_test")
    private Date expiredTest;

    @Column(name = "user_access")
    private String userAccess;

    @Column(name = "status")
    private String status;

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
     * @return String return the periodeCode
     */
    public String getPeriodeCode() {
        return periodeCode;
    }

    /**
     * @param periodeCode the periodeCode to set
     */
    public void setPeriodeCode(String periodeCode) {
        this.periodeCode = periodeCode;
    }

    /**
     * @return Integer return the period
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * @return Date return the testDate
     */
    public Date getTestDate() {
        return testDate;
    }

    /**
     * @param testDate the testDate to set
     */
    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    /**
     * @return Date return the expiredTest
     */
    public Date getExpiredTest() {
        return expiredTest;
    }

    /**
     * @param expiredTest the expiredTest to set
     */
    public void setExpiredTest(Date expiredTest) {
        this.expiredTest = expiredTest;
    }

    /**
     * @return String return the userAccess
     */
    public String getUserAccess() {
        return userAccess;
    }

    /**
     * @param userAccess the userAccess to set
     */
    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}