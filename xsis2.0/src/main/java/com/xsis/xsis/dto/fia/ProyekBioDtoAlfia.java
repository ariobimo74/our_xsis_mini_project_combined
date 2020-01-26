package com.xsis.xsis.dto.fia;

public class ProyekBioDtoAlfia {
    private Long id;
    private Boolean isDelete;
    private Long riwayatPekerjaanId;
    private String startYear;
    private String startMonth;
    private String projectName;
    private Integer projectDuration;
    private Long timePeriodId;
    private String name;
    private String client;
    private String projectPosition;
    private String description;

    public ProyekBioDtoAlfia() {
    }

    public ProyekBioDtoAlfia(Long id, Boolean isDelete, Long riwayatPekerjaanId, String startYear, String startMonth,
            String projectName, Integer projectDuration, Long timePeriodId, String name, String client,
            String projectPosition, String description) {
        this.id = id;
        this.isDelete = isDelete;
        this.riwayatPekerjaanId = riwayatPekerjaanId;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.projectName = projectName;
        this.projectDuration = projectDuration;
        this.timePeriodId = timePeriodId;
        this.name = name;
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

    public Boolean isIsDelete() {
        return this.isDelete;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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