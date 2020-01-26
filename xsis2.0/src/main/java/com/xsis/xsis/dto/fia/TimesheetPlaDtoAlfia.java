package com.xsis.xsis.dto.fia;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TimesheetPlaDtoAlfia {

    public Long id;
    public Boolean isdelete;
    public String fullname;
    public String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.DATE)
    public Date timesheetDate;

    public String start;
    public String end;
    public Boolean overtime;
    public String startOt;
    public String endOt;
    public String activity;
    public String userApproval;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    public Date submittedOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    public Date approvedOn;
    public String eroStatus;
    public Long clientId;
    public Long employeeId;
    public Boolean isPlacementActive;
    public String name;
    public Boolean isEro;

    public TimesheetPlaDtoAlfia() {
    }

    public TimesheetPlaDtoAlfia(Long id, Boolean isdelete, String fullname, String status, Date timesheetDate,
            String start, String end, Boolean overtime, String startOt, String endOt, String activity,
            String userApproval, Date submittedOn, Date approvedOn, String eroStatus, Long clientId, Long employeeId,
            Boolean isPlacementActive, String name, Boolean isEro) {
        this.id = id;
        this.isdelete = isdelete;
        this.fullname = fullname;
        this.status = status;
        this.timesheetDate = timesheetDate;
        this.start = start;
        this.end = end;
        this.overtime = overtime;
        this.startOt = startOt;
        this.endOt = endOt;
        this.activity = activity;
        this.userApproval = userApproval;
        this.submittedOn = submittedOn;
        this.approvedOn = approvedOn;
        this.eroStatus = eroStatus;
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.isPlacementActive = isPlacementActive;
        this.name = name;
        this.isEro = isEro;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isIsdelete() {
        return this.isdelete;
    }

    public Boolean getIsdelete() {
        return this.isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimesheetDate() {
        return this.timesheetDate;
    }

    public void setTimesheetDate(Date timesheetDate) {
        this.timesheetDate = timesheetDate;
    }

    public String getStart() {
        return this.start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Boolean isOvertime() {
        return this.overtime;
    }

    public Boolean getOvertime() {
        return this.overtime;
    }

    public void setOvertime(Boolean overtime) {
        this.overtime = overtime;
    }

    public String getStartOt() {
        return this.startOt;
    }

    public void setStartOt(String startOt) {
        this.startOt = startOt;
    }

    public String getEndOt() {
        return this.endOt;
    }

    public void setEndOt(String endOt) {
        this.endOt = endOt;
    }

    public String getActivity() {
        return this.activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getUserApproval() {
        return this.userApproval;
    }

    public void setUserApproval(String userApproval) {
        this.userApproval = userApproval;
    }

    public Date getSubmittedOn() {
        return this.submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Date getApprovedOn() {
        return this.approvedOn;
    }

    public void setApprovedOn(Date approvedOn) {
        this.approvedOn = approvedOn;
    }

    public String getEroStatus() {
        return this.eroStatus;
    }

    public void setEroStatus(String eroStatus) {
        this.eroStatus = eroStatus;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean isIsPlacementActive() {
        return this.isPlacementActive;
    }

    public Boolean getIsPlacementActive() {
        return this.isPlacementActive;
    }

    public void setIsPlacementActive(Boolean isPlacementActive) {
        this.isPlacementActive = isPlacementActive;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isIsEro() {
        return this.isEro;
    }

    public Boolean getIsEro() {
        return this.isEro;
    }

    public void setIsEro(Boolean isEro) {
        this.isEro = isEro;
    }

}