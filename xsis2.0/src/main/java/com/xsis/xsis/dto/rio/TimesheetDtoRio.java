package com.xsis.xsis.dto.rio;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TimesheetDtoRio
{
    private Long id;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    private Date date;
    private String client;
    private Long employeeid;
    private String approval;
    private String erostat;
    private Date senton;
    private Boolean isdelete;

    public TimesheetDtoRio() {
    }

    public TimesheetDtoRio(Long id, String status, Date date, String client, Long employeeid, String approval, String erostat, Date senton, Boolean isdelete) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.client = client;
        this.employeeid = employeeid;
        this.approval = approval;
        this.erostat = erostat;
        this.senton = senton;
        this.isdelete = isdelete;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Long employeeid) {
        this.employeeid = employeeid;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getErostat() {
        return erostat;
    }

    public void setErostat(String erostat) {
        this.erostat = erostat;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Date getSenton() {
        return senton;
    }

    public void setSenton(Date senton) {
        this.senton = senton;
    }
}
