package com.xsis.xsis.dto.kur;

import java.util.Date;

import com.xsis.xsis.model.kur.EmployeeKur;
import com.xsis.xsis.model.kur.ScheduleTypeKur;

public class RencanaJadwalTypeDtoKur {
    private Long id;
    private String scheduleCode;
    private Date scheduleDate;
    private String time;
    private EmployeeKur ro;
    private EmployeeKur tro;
    private ScheduleTypeKur scheduleTypeId;
    private String location;
    private String otherRoTro;
    private String notes;
    private Boolean isAutomaticMail;
    private Date sentDate;

    public RencanaJadwalTypeDtoKur() {
    }

    public RencanaJadwalTypeDtoKur(Long id, String scheduleCode, Date scheduleDate, String time, EmployeeKur ro,
            EmployeeKur tro, ScheduleTypeKur scheduleTypeId, String location, String otherRoTro, String notes,
            Boolean isAutomaticMail, Date sentDate) {
        this.id = id;
        this.scheduleCode = scheduleCode;
        this.scheduleDate = scheduleDate;
        this.time = time;
        this.ro = ro;
        this.tro = tro;
        this.scheduleTypeId = scheduleTypeId;
        this.location = location;
        this.otherRoTro = otherRoTro;
        this.notes = notes;
        this.isAutomaticMail = isAutomaticMail;
        this.sentDate = sentDate;
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
     * @return String return the scheduleCode
     */
    public String getScheduleCode() {
        return scheduleCode;
    }

    /**
     * @param scheduleCode the scheduleCode to set
     */
    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    /**
     * @return Date return the scheduleDate
     */
    public Date getScheduleDate() {
        return scheduleDate;
    }

    /**
     * @param scheduleDate the scheduleDate to set
     */
    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    /**
     * @return String return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return Employee return the ro
     */
    public EmployeeKur getRo() {
        return ro;
    }

    /**
     * @param ro the ro to set
     */
    public void setRo(EmployeeKur ro) {
        this.ro = ro;
    }

    /**
     * @return Employee return the tro
     */
    public EmployeeKur getTro() {
        return tro;
    }

    /**
     * @param tro the tro to set
     */
    public void setTro(EmployeeKur tro) {
        this.tro = tro;
    }

    /**
     * @return ScheduleType return the scheduleTypeId
     */
    public ScheduleTypeKur getScheduleTypeId() {
        return scheduleTypeId;
    }

    /**
     * @param scheduleTypeId the scheduleTypeId to set
     */
    public void setScheduleTypeId(ScheduleTypeKur scheduleTypeId) {
        this.scheduleTypeId = scheduleTypeId;
    }

    /**
     * @return String return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return String return the otherRoTro
     */
    public String getOtherRoTro() {
        return otherRoTro;
    }

    /**
     * @param otherRoTro the otherRoTro to set
     */
    public void setOtherRoTro(String otherRoTro) {
        this.otherRoTro = otherRoTro;
    }

    /**
     * @return String return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return Boolean return the isAutomaticMail
     */
    public Boolean isIsAutomaticMail() {
        return isAutomaticMail;
    }

    /**
     * @param isAutomaticMail the isAutomaticMail to set
     */
    public void setIsAutomaticMail(Boolean isAutomaticMail) {
        this.isAutomaticMail = isAutomaticMail;
    }

    /**
     * @return Date return the sentDate
     */
    public Date getSentDate() {
        return sentDate;
    }

    /**
     * @param sentDate the sentDate to set
     */
    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

}