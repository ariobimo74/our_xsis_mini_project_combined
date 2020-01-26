package com.xsis.xsis.model.fathan;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.models.common.CommonEntity;

/**
 * AddressBook
 */
@Entity
@Table(name = "x_addrbook")
public class AddressBook extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_locked")
    private Boolean isLocked;

    @Column(name = "attempt")
    private Integer attempt;

    @Column(name = "email")
    private String email;

    @Column(name = "abuid")
    private String abuid;

    @Column(name = "abpwd")
    private String abpwd;

    @Column(name = "fp_token")
    private String fpToken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm-ss")
    @Column(name = "fp_expired_date")
    private Date fpExpiredDate;

    @Column(name = "fp_counter")
    private Integer fpCounter;

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
     * @return Boolean return the isLocked
     */
    public Boolean isIsLocked() {
        return isLocked;
    }

    /**
     * @param isLocked the isLocked to set
     */
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * @return Integer return the attempt
     */
    public Integer getAttempt() {
        return attempt;
    }

    /**
     * @param attempt the attempt to set
     */
    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the abuid
     */
    public String getAbuid() {
        return abuid;
    }

    /**
     * @param abuid the abuid to set
     */
    public void setAbuid(String abuid) {
        this.abuid = abuid;
    }

    /**
     * @return String return the abpwd
     */
    public String getAbpwd() {
        return abpwd;
    }

    /**
     * @param abpwd the abpwd to set
     */
    public void setAbpwd(String abpwd) {
        this.abpwd = abpwd;
    }

    /**
     * @return String return the fpToken
     */
    public String getFpToken() {
        return fpToken;
    }

    /**
     * @param fpToken the fpToken to set
     */
    public void setFpToken(String fpToken) {
        this.fpToken = fpToken;
    }

    /**
     * @return Date return the fpExpiredDate
     */
    public Date getFpExpiredDate() {
        return fpExpiredDate;
    }

    /**
     * @param fpExpiredDate the fpExpiredDate to set
     */
    public void setFpExpiredDate(Date fpExpiredDate) {
        this.fpExpiredDate = fpExpiredDate;
    }

    /**
     * @return Integer return the fpCounter
     */
    public Integer getFpCounter() {
        return fpCounter;
    }

    /**
     * @param fpCounter the fpCounter to set
     */
    public void setFpCounter(Integer fpCounter) {
        this.fpCounter = fpCounter;
    }

}