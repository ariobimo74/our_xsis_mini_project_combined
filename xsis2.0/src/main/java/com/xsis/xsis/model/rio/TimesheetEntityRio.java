package com.xsis.xsis.model.rio;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.dto.rio.TimesheetDtoRio;
import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;
import java.util.Date;

@SqlResultSetMapping(name = "timesheetMapping", classes = {
        @ConstructorResult(targetClass = TimesheetDtoRio.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "status", type = String.class),
                @ColumnResult(name = "date", type = Date.class), @ColumnResult(name = "client", type = String.class),
                @ColumnResult(name = "employeeid", type = Long.class),
                @ColumnResult(name = "approval", type = String.class),
                @ColumnResult(name = "erostat", type = String.class), @ColumnResult(name = "senton", type = Date.class),
                @ColumnResult(name = "isdelete", type = Boolean.class) }) })

@NamedNativeQuery(name = "TimesheetEntityRio.getPlacementId", resultSetMapping = "timesheetMapping", query = "SELECT timesheet.id, timesheet.status AS status, "
        + "timesheet.timesheet_date AS date, " + "client.name AS client, " + "employee.id AS employeeid, "
        + "timesheet.user_approval AS approval, " + "timesheet.ero_status AS erostat, "
        + "timesheet.sent_on AS senton, " + "timesheet.isdelete\n" + "FROM x_timesheet AS timesheet\n"
        + "JOIN x_placement AS placement\n" + "ON timesheet.placement_id = placement.id\n" + "JOIN x_client AS client\n"
        + "ON placement.client_id = client.id\n" + "JOIN x_employee AS employee\n"
        + "ON placement.employee_id = employee.id\n" + "AND timesheet.user_approval = 'Approved'\n"
        + "AND timesheet.isdelete = false\n" + "AND timesheet.ero_status IS null\n"
        + "AND timesheet.placement_id=:placementId")

@NamedNativeQuery(name = "TimesheetEntityRio.searchTimesheetDate", resultSetMapping = "timesheetMapping", query = "SELECT timesheet.id, timesheet.status AS status, "
        + "timesheet.timesheet_date AS date, " + "client.name AS client, " + "employee.id AS employeeid, "
        + "timesheet.user_approval AS approval, " + "timesheet.ero_status AS erostat, "
        + "timesheet.sent_on AS senton, " + "timesheet.isdelete\n" + "FROM x_timesheet AS timesheet\n"
        + "JOIN x_placement AS placement\n" + "ON timesheet.placement_id = placement.id\n" + "JOIN x_client AS client\n"
        + "ON placement.client_id = client.id\n" + "JOIN x_employee AS employee\n"
        + "ON placement.employee_id = employee.id\n" + "AND timesheet.user_approval = 'Approved'\n"
        + "AND timesheet.isdelete = false\n" + "AND timesheet.ero_status IS null\n"
        + "AND (date_part('year', timesheet.timesheet_date) =:stYear\n"
        + "AND date_part('month', timesheet.timesheet_date) =:stMonth)")

@NamedNativeQuery(name = "TimesheetEntityRio.searchTimesheetDateByPlacementId", resultSetMapping = "timesheetMapping", query = "SELECT timesheet.id, timesheet.status AS status, "
        + "timesheet.timesheet_date AS date, " + "client.name AS client, " + "employee.id AS employeeid, "
        + "timesheet.user_approval AS approval, " + "timesheet.ero_status AS erostat, "
        + "timesheet.sent_on AS senton, " + "timesheet.isdelete\n" + "FROM x_timesheet AS timesheet\n"
        + "JOIN x_placement AS placement\n" + "ON timesheet.placement_id = placement.id\n" + "JOIN x_client AS client\n"
        + "ON placement.client_id = client.id\n" + "JOIN x_employee AS employee\n"
        + "ON placement.employee_id = employee.id\n" + "AND timesheet.user_approval = 'Approved'\n"
        + "AND timesheet.isdelete = false\n" + "AND timesheet.ero_status IS null\n"
        + "AND timesheet.placement_id=:placementId\n" + "AND (date_part('year', timesheet.timesheet_date) =:stYear\n"
        + "AND date_part('month', timesheet.timesheet_date) =:stMonth)")

@Entity
@Table(name = "x_timesheet")
public class TimesheetEntityRio extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "placement_id", nullable = false)
    private Long placementId;

    @Column(name = "timesheet_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    private Date timesheetDate;

    @Column(name = "user_approval")
    private String userApproval;

    @Column(name = "ero_status")
    private String eroStatus;

    @Column(name = "sent_on")
    private Date sentOn;

    public TimesheetEntityRio() {
    }

    public TimesheetEntityRio(Long id, String status, Long placementId, Date timesheetDate, String userApproval,
            String eroStatus, Date sentOn) {
        this.id = id;
        this.status = status;
        this.placementId = placementId;
        this.timesheetDate = timesheetDate;
        this.userApproval = userApproval;
        this.eroStatus = eroStatus;
        this.sentOn = sentOn;
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

    public Long getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Long placementId) {
        this.placementId = placementId;
    }

    public Date getTimesheetDate() {
        return timesheetDate;
    }

    public void setTimesheetDate(Date timesheetDate) {
        this.timesheetDate = timesheetDate;
    }

    public String getUserApproval() {
        return userApproval;
    }

    public void setUserApproval(String userApproval) {
        this.userApproval = userApproval;
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
}
