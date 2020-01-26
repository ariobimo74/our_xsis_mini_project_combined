package com.xsis.xsis.model.dhika;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.models.common.CommonEntity;

/**
 * Permission
 */

@Entity
@Table(name = "x_permission")
public class PermissionDika extends CommonEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "department")
    private String department;

    @Column(name = "position")
    private String position;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+07:00")
    @Column(name = "permission_time")
    private Date permissionTime;

    @Column(name = "notes")
    private String notes;

    @Column(name = "is_absent")
    private Boolean isAbsent;

    @Column(name = "is_sick")
    private Boolean isSick;

    @Column(name = "is_coming_late")
    private Boolean isComingLate;

    @Column(name = "is_early_leave")
    private Boolean isEarlyLeave;

    @Column(name = "others")
    private Boolean others;

    @Column(name = "status")
    private String status;

    public PermissionDika() {

    }

    public PermissionDika(Long id, String employeeName, String department, String position, Date permissionTime,
            String notes, Boolean isAbsent, Boolean isSick, Boolean isComingLate, Boolean isEarlyLeave, Boolean others,
            String status) {
        this.id = id;
        this.employeeName = employeeName;
        this.department = department;
        this.position = position;
        this.permissionTime = permissionTime;
        this.notes = notes;
        this.isAbsent = isAbsent;
        this.isSick = isSick;
        this.isComingLate = isComingLate;
        this.isEarlyLeave = isEarlyLeave;
        this.others = others;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getPermissionTime() {
        return permissionTime;
    }

    public void setPermissionTime(Date permissionTime) {
        this.permissionTime = permissionTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getIsAbsent() {
        return isAbsent;
    }

    public void setIsAbsent(Boolean isAbsent) {
        this.isAbsent = isAbsent;
    }

    public Boolean getIsSick() {
        return isSick;
    }

    public void setIsSick(Boolean isSick) {
        this.isSick = isSick;
    }

    public Boolean getIsComingLate() {
        return isComingLate;
    }

    public void setIsComingLate(Boolean isComingLate) {
        this.isComingLate = isComingLate;
    }

    public Boolean getIsEarlyLeave() {
        return isEarlyLeave;
    }

    public void setIsEarlyLeave(Boolean isEarlyLeave) {
        this.isEarlyLeave = isEarlyLeave;
    }

    public Boolean getOthers() {
        return others;
    }

    public void setOthers(Boolean others) {
        this.others = others;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}