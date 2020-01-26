package com.xsis.xsis.model.dhika;

import javax.persistence.*;

import com.xsis.xsis.dto.dhika.pelatihanDtoDika;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "pelatihanMapping", classes = {
        @ConstructorResult(targetClass = pelatihanDtoDika.class, columns = { @ColumnResult(name = "id", type = Long.class),
                @ColumnResult(name = "biodata_id", type = Long.class),
                @ColumnResult(name = "training_name", type = String.class),
                @ColumnResult(name = "organizer", type = String.class),
                @ColumnResult(name = "training_year", type = String.class),
                @ColumnResult(name = "training_month", type = String.class),
                @ColumnResult(name = "training_duration", type = Integer.class),
                @ColumnResult(name = "time_period_id", type = Long.class),
                @ColumnResult(name = "name", type = String.class), @ColumnResult(name = "city", type = String.class),
                @ColumnResult(name = "country", type = String.class),
                @ColumnResult(name = "notes", type = String.class) }) })

@NamedNativeQuery(name = "PelatihanDika.getPelatihan", query = "select a.id, a.biodata_id, a.training_name, a.organizer, a.training_year, a.training_month, a.training_duration, a.time_period_id, b.name, a.city, a.country, a.notes"
        + " from x_pelatihan a left join x_time_period b on b.id = a.time_period_id where a.biodata_id=:biodataId and a.isdelete=false", resultSetMapping = "pelatihanMapping")

@NamedNativeQuery(name = "PelatihanDika.getPelatihanDetail", query = "select a.id, a.biodata_id, a.training_name, a.organizer, a.training_year, a.training_month, a.training_duration, a.time_period_id, b.name, a.city, a.country, a.notes"
        + " from x_pelatihan a join x_time_period b on b.id = a.time_period_id where (a.biodata_id=:biodataId and a.id=:id) and a.isdelete=false", resultSetMapping = "pelatihanMapping")

/**
 * Pelatihan
 */
@Entity
@Table(name = "x_pelatihan")
public class PelatihanDika extends CommonEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "training_name")
    private String trainingName;

    @Column(name = "organizer")
    private String organizer;

    @Column(name = "training_year")
    private String trainingYear;

    @Column(name = "training_month")
    private String trainingMonth;

    @Column(name = "training_duration")
    private Integer trainingDuration;

    @Column(name = "time_period_id")
    private Long timePeriodId;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "notes")
    private String notes;

    public PelatihanDika() {

    }

    public PelatihanDika(Long id, Long biodataId, String trainingName, String organizer, String trainingYear,
            String trainingMonth, Integer trainingDuration, Long timePeriodId, String city, String country,
            String notes) {

        this.id = id;
        this.biodataId = biodataId;
        this.trainingName = trainingName;
        this.organizer = organizer;
        this.trainingYear = trainingYear;
        this.trainingMonth = trainingMonth;
        this.trainingDuration = trainingDuration;
        this.timePeriodId = timePeriodId;
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

}