package com.xsis.xsis.model.fia;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.dto.fia.TimesheetPlaDtoAlfia;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "timesheetAlfiaMapping", classes = {
        @ConstructorResult(targetClass = TimesheetPlaDtoAlfia.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "fullname", type = String.class),
                @ColumnResult(name = "status", type = String.class),
                @ColumnResult(name = "timesheet_date", type = Date.class),
                @ColumnResult(name = "start", type = String.class),
                @ColumnResult(name = "end_date", type = String.class),
                @ColumnResult(name = "overtime", type = Boolean.class),
                @ColumnResult(name = "start_ot", type = String.class),
                @ColumnResult(name = "end_ot", type = String.class),
                @ColumnResult(name = "activity", type = String.class),
                @ColumnResult(name = "user_approval", type = String.class),
                @ColumnResult(name = "submitted_on", type = Date.class),
                @ColumnResult(name = "approved_on", type = Date.class),
                @ColumnResult(name = "ero_status", type = String.class),
                @ColumnResult(name = "client_id", type = Long.class),
                @ColumnResult(name = "employee_id", type = Long.class),
                @ColumnResult(name = "is_placement_active", type = Boolean.class),
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "is_ero", type = Boolean.class), }) })

@NamedNativeQuery(name = "TimesheetAlfia.joinTimesheet", query = "select a.id,a.isdelete,a.status,a.timesheet_date,a.start,a.end_date,a.overtime,a.start_ot,a.end_ot,a.activity,"
        + "a.user_approval,a.submitted_on,a.approved_on,a.ero_status,b.client_id,b.employee_id,b.is_placement_active,c.name,"
        + "e.is_ero,f.fullname from x_timesheet a join x_placement b on b.id=a.placement_id join x_client c on c.id=b.client_id "
        + "join x_employee d on d.id=b.employee_id join x_employee e on e.id=c.ero join x_biodata f on f.id=e.biodata_id "
        + "where a.isdelete=false and b.isdelete=false and c.isdelete=false and d.isdelete=false and e.is_ero=true and a.user_approval='submitted' and a.ero_status is null", resultSetMapping = "timesheetAlfiaMapping")

@NamedNativeQuery(name = "TimesheetAlfia.searchTimesheet", query = "select a.id,a.isdelete,a.status,a.timesheet_date,a.start,a.end_date,a.overtime,a.start_ot,a.end_ot,a.activity,"
        + "a.user_approval,a.submitted_on,a.approved_on,a.ero_status,b.client_id,b.employee_id,b.is_placement_active,c.name,e.is_ero,f.fullname "
        + "from x_timesheet a join x_placement b on b.id=a.placement_id join x_client c on c.id=b.client_id join x_employee d on d.id=b.employee_id join x_employee e on e.id=c.ero join x_biodata f on f.id=e.biodata_id "
        + "where (a.isdelete=false and b.isdelete=false and c.isdelete=false and d.isdelete=false and e.is_ero=true and a.user_approval='submitted' and a.ero_status is null) and (cast(a.timesheet_date as varchar) like concat('%',:yearmonth,'%'))", resultSetMapping = "timesheetAlfiaMapping")

@NamedNativeQuery(name = "TimesheetAlfia.findByIdTS", query = "select a.id,a.isdelete,a.status,a.timesheet_date,a.start,a.end_date,a.overtime,a.start_ot,a.end_ot,a.activity,"
        + "a.user_approval,a.submitted_on,a.approved_on,a.ero_status,b.client_id,b.employee_id,b.is_placement_active,c.name,e.is_ero,f.fullname "
        + "from x_timesheet a join x_placement b on b.id=a.placement_id join x_client c on c.id=b.client_id join x_employee d on d.id=b.employee_id join x_employee e on e.id=c.ero join x_biodata f on f.id=e.biodata_id "
        + "where (a.isdelete=false and b.isdelete=false and c.isdelete=false and d.isdelete=false and e.is_ero=true) and (a.id= :idsearch)", resultSetMapping = "timesheetAlfiaMapping")

@Entity
@Table(name = "x_timesheet")
public class TimesheetAlfia extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status", nullable = false)
    @Size(max = 15)
    private String status;

    @Column(name = "placement_id", nullable = false)
    private Long placementId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timesheet_date", nullable = false)
    private Date timesheetDate;

    @Column(name = "start", nullable = false)
    @Size(max = 5)
    private String start;

    @Column(name = "end_date", nullable = false)
    @Size(max = 5)
    private String end;

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
    @Column(name = "approved_on", nullable = false)
    private Date approvedOn;

    @Column(name = "ero_status")
    @Size(max = 50)
    private String eroStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sent_on", nullable = false)
    private Date sentOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "collected_on", nullable = false)
    private Date collectedOn;

    public TimesheetAlfia() {
    }

    public TimesheetAlfia(String status, Long placementId, Date timesheetDate, String start, String end,
            Boolean overtime, String startOt, String endOt, String activity, String userApproval, Date submittedOn,
            Date approvedOn, String eroStatus, Date sentOn, Date collectedOn) {
        this.status = status;
        this.placementId = placementId;
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
        this.sentOn = sentOn;
        this.collectedOn = collectedOn;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPlacementId() {
        return this.placementId;
    }

    public void setPlacementId(Long placementId) {
        this.placementId = placementId;
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

    public Date getSentOn() {
        return this.sentOn;
    }

    public void setSentOn(Date sentOn) {
        this.sentOn = sentOn;
    }

    public Date getCollectedOn() {
        return this.collectedOn;
    }

    public void setCollectedOn(Date collectedOn) {
        this.collectedOn = collectedOn;
    }

}