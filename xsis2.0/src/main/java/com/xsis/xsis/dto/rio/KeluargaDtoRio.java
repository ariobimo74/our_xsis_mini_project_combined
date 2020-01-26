package com.xsis.xsis.dto.rio;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class KeluargaDtoRio
{
    private Long id;
    private String hubungan;
    private String name;
    private Boolean gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    private Date dob;
    private String educationName;
    private String job;
    private Boolean isDelete;

    public KeluargaDtoRio() {
    }

    public KeluargaDtoRio(Long id, String hubungan, String name, Boolean gender, Date dob, String educationName, String job, Boolean isDelete) {
        this.id = id;
        this.hubungan = hubungan;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.educationName = educationName;
        this.job = job;
        this.isDelete = isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHubungan() {
        return hubungan;
    }

    public void setHubungan(String hubungan) {
        this.hubungan = hubungan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

}