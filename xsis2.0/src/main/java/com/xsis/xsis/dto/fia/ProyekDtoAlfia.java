package com.xsis.xsis.dto.fia;

public class ProyekDtoAlfia {
    private Long id;
    private Long riwayatPekerjaanId;
    private String startYear;
    private String startMonth;
    private String projectName;
    private Integer projectDuration;
    private Long timePeriodId;
    private String client;
    private String projectPosition;
    private String description;

    public ProyekDtoAlfia() {
    }

    public ProyekDtoAlfia(Long id, Long riwayatPekerjaanId, String startYear, String startMonth, String projectName,
            Integer projectDuration, Long timePeriodId, String client, String projectPosition, String description) {
        this.id = id;
        this.riwayatPekerjaanId = riwayatPekerjaanId;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.projectName = projectName;
        this.projectDuration = projectDuration;
        this.timePeriodId = timePeriodId;
        this.client = client;
        this.projectPosition = projectPosition;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRiwayatPekerjaanId() {
        return this.riwayatPekerjaanId;
    }

    public void setRiwayatPekerjaanId(Long riwayatPekerjaanId) {
        this.riwayatPekerjaanId = riwayatPekerjaanId;
    }

    public String getStartYear() {
        return this.startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getStartMonth() {
        return this.startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getProjectDuration() {
        return this.projectDuration;
    }

    public void setProjectDuration(Integer projectDuration) {
        this.projectDuration = projectDuration;
    }

    public Long getTimePeriodId() {
        return this.timePeriodId;
    }

    public void setTimePeriodId(Long timePeriodId) {
        this.timePeriodId = timePeriodId;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProjectPosition() {
        return this.projectPosition;
    }

    public void setProjectPosition(String projectPosition) {
        this.projectPosition = projectPosition;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}