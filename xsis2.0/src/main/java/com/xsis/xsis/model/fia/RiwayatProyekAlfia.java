package com.xsis.xsis.model.fia;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.xsis.xsis.dto.fia.ProyekBioDtoAlfia;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "proyekAlfiaMapping", classes = {
        @ConstructorResult(targetClass = ProyekBioDtoAlfia.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "riwayat_pekerjaan_id", type = Long.class),
                @ColumnResult(name = "start_year", type = String.class),
                @ColumnResult(name = "start_month", type = String.class),
                @ColumnResult(name = "project_name", type = String.class),
                @ColumnResult(name = "project_duration", type = Integer.class),
                @ColumnResult(name = "time_period_id", type = Long.class),
                @ColumnResult(name = "name", type = String.class), @ColumnResult(name = "client", type = String.class),
                @ColumnResult(name = "project_position", type = String.class),
                @ColumnResult(name = "description", type = String.class) }) })

@NamedNativeQuery(name = "RiwayatProyekAlfia.getPengkerId", query = "select a.id,a.isdelete,a.riwayat_pekerjaan_id,a.start_year,a.start_month,"
        + "a.project_name,a.project_duration,a.time_period_id,b.name,a.client,a.project_position,a.description "
        + "from x_riwayat_proyek as a join x_time_period as b on b.id=a.time_period_id "
        + "join x_riwayat_pekerjaan as c on c.id=a.riwayat_pekerjaan_id "
        + "where a.riwayat_pekerjaan_id=:riwayatPekerjaanId and a.isdelete=false and b.isdelete=false and c.isdelete=false", resultSetMapping = "proyekAlfiaMapping")

@Entity
@Table(name = "x_riwayat_proyek")
public class RiwayatProyekAlfia extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "riwayat_pekerjaan_id", nullable = false)
    private Long riwayatPekerjaanId;

    @Column(name = "start_year")
    @Size(max = 10)
    private String startYear;

    @Column(name = "start_month")
    @Size(max = 10)
    private String startMonth;

    @Column(name = "project_name")
    @Size(max = 50)
    private String projectName;

    @Column(name = "project_duration")
    private Integer projectDuration;

    @Column(name = "time_period_id")
    private Long timePeriodId;

    @Column(name = "client")
    @Size(max = 100)
    private String client;

    @Column(name = "project_position")
    @Size(max = 100)
    private String projectPosition;

    @Column(name = "description")
    @Size(max = 1000)
    private String description;

    public RiwayatProyekAlfia() {
    }

    public RiwayatProyekAlfia(Long riwayatPekerjaanId, String startYear, String startMonth, String projectName,
            Integer projectDuration, Long timePeriodId, String client, String projectPosition, String description) {
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