package com.xsis.xsis.dto.dhika;

import java.util.Date;

import com.xsis.xsis.model.dhika.PlacementDika;

/**
 * TimesheetDto
 */
public class TimesheetDtoDika {

    private Long id;
    private String status;
    private PlacementDika placementId;
    private Date timesheetDate;
    private String start;
    private String endTime;
    private Boolean overtime;
    private String startOt;
    private String endOt;
    private String activity;
    private String userApproval;
    private Date submittedOn;
    private Date approvedOn;
    private String eroStatus;
    private Date sentOn;
    private Date collectedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PlacementDika getPlacementId() {
        return placementId;
    }

    public void setPlacementId(PlacementDika placementId) {
        this.placementId = placementId;
    }

    public Date getTimesheetDate() {
        return timesheetDate;
    }

    public void setTimesheetDate(Date timesheetDate) {
        this.timesheetDate = timesheetDate;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getOvertime() {
        return overtime;
    }

    public void setOvertime(Boolean overtime) {
        this.overtime = overtime;
    }

    public String getStartOt() {
        return startOt;
    }

    public void setStartOt(String startOt) {
        this.startOt = startOt;
    }

    public String getEndOt() {
        return endOt;
    }

    public void setEndOt(String endOt) {
        this.endOt = endOt;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getUserApproval() {
        return userApproval;
    }

    public void setUserApproval(String userApproval) {
        this.userApproval = userApproval;
    }

    public Date getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Date getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(Date approvedOn) {
        this.approvedOn = approvedOn;
    }

    public String getEroStatus() {
        return eroStatus;
    }

    public void setEroStatus(String eroStatus) {
        this.eroStatus = eroStatus;
    }

    public Date getSentOn() {
        return sentOn;
    }

    public void setSentOn(Date sentOn) {
        this.sentOn = sentOn;
    }

    public Date getCollectedOn() {
        return collectedOn;
    }

    public void setCollectedOn(Date collectedOn) {
        this.collectedOn = collectedOn;
    }

}