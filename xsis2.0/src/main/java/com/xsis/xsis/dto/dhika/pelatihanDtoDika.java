package com.xsis.xsis.dto.dhika;

/**
 * pelatihanDto
 */
public class pelatihanDtoDika {

    private Long id;
    private Long biodataId;
    private String trainingName;
    private String organizer;
    private String trainingYear;
    private String trainingMonth;
    private Integer trainingDuration;
    private Long timePeriodId;
    private String name;
    private String city;
    private String country;
    private String notes;

    public pelatihanDtoDika() {

    }

    public pelatihanDtoDika(Long id, Long biodataId, String trainingName, String organizer, String trainingYear,
            String trainingMonth, Integer trainingDuration, Long timePeriodId, String name, String city, String country,
            String notes) {

        this.id = id;
        this.biodataId = biodataId;
        this.trainingName = trainingName;
        this.organizer = organizer;
        this.trainingYear = trainingYear;
        this.trainingMonth = trainingMonth;
        this.trainingDuration = trainingDuration;
        this.timePeriodId = timePeriodId;
        this.name = name;
        this.city = city;
        this.country = country;
        this.notes = notes;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getTrainingYear() {
        return trainingYear;
    }

    public void setTrainingYear(String trainingYear) {
        this.trainingYear = trainingYear;
    }

    public String getTrainingMonth() {
        return trainingMonth;
    }

    public void setTrainingMonth(String trainingMonth) {
        this.trainingMonth = trainingMonth;
    }

    public Integer getTrainingDuration() {
        return trainingDuration;
    }

    public void setTrainingDuration(Integer trainingDuration) {
        this.trainingDuration = trainingDuration;
    }

    public Long getTimePeriodId() {
        return timePeriodId;
    }

    public void setTimePeriodId(Long timePeriodId) {
        this.timePeriodId = timePeriodId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}