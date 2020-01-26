package com.xsis.xsis.model.dhika;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.models.common.CommonEntity;

/**
 * Timesheet
 */
@Entity
@Table(name = "x_timesheet")
public class TimesheetDika extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status", nullable = false)
    @Size(max = 15)
    private String status;

    @ManyToOne
    @JoinColumn(name = "placement_id", nullable = false, referencedColumnName = "id")
    private PlacementDika placementId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timesheet_date", nullable = false)
    private Date timesheetDate;

    @Column(name = "start", nullable = false)
    @Size(max = 5)
    private String start;

    @Column(name = "end_time", nullable = false)
    @Size(max = 5)
    private String endTime;

    @Column(name = "overtime")
    private Boolean overtime;

    @Column(name = "start_ot")
    private String startOt;

    @Column(name = "end_ot")
    private String endOt;

    @Column(name = "activity", nullable = false)
    @Size(max = 255)
    private String activity;

    @Column(name = "user_approval")
    @Size(max = 50)
    private String userApproval;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "submitted_on", nullable = false)
    private Date submittedOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "approved_on")
    private Date approvedOn;

    @Column(name = "ero_status")
    @Size(max = 50)
    private String eroStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sent_on")
    private Date sentOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "collected_on")
    private Date collectedOn;

    public TimesheetDika() {
    }

    public TimesheetDika(Long id, @Size(max = 15) String status, PlacementDika placementId, Date timesheetDate,
            @Size(max = 5) String start, @Size(max = 5) String endTime, Boolean overtime, String startOt, String endOt,
            @Size(max = 255) String activity, @Size(max = 50) String userApproval, Date submittedOn, Date approvedOn,
            @Size(max = 50) String eroStatus, Date sentOn, Date collectedOn) {
        this.id = id;
        this.status = status;
        this.placementId = placementId;
        this.timesheetDate = timesheetDate;
        this.start = start;
        this.endTime = endTime;
        this.overtime = overtime;
        this.startOt = startOt;
        this.endOt = endOt;
        this.activity = activity;
        this.userApproval = userApproval;
        this.submittedOn = submittedOn;
        this.approvedOn = approvedOn;
        this.eroStatus = eroStatus;
        this.sentOn = sentOn;
        this.collectedOn = collectedOn;
    }

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