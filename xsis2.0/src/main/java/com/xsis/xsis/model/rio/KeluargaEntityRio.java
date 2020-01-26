package com.xsis.xsis.model.rio;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.dto.rio.KeluargaDtoRio;
import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;
import java.util.Date;

@SqlResultSetMapping(name = "keluargaMapping", classes = {
        @ConstructorResult(targetClass = KeluargaDtoRio.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "hubungan", type = String.class),
                @ColumnResult(name = "name", type = String.class), @ColumnResult(name = "gender", type = Boolean.class),
                @ColumnResult(name = "dob", type = Date.class), @ColumnResult(name = "pendidikan", type = String.class),
                @ColumnResult(name = "job", type = String.class),
                @ColumnResult(name = "isdelete", type = Boolean.class) }) })

@NamedNativeQuery(name = "KeluargaEntityRio.getBioId", resultSetMapping = "keluargaMapping", query = "SELECT keluarga.id, family_relation.name AS hubungan, keluarga.name, keluarga.gender, keluarga.dob, education_level.name AS pendidikan, keluarga.job, keluarga.isdelete\n"
        + "FROM \n" + "x_biodata AS biodata,\n" + "x_family_tree_type AS family_tree_type,\n"
        + "x_family_relation AS family_relation,\n" + "x_keluarga AS keluarga,\n"
        + "x_education_level AS education_level\n" + "WHERE keluarga.biodata_id = biodata.id\n"
        + "AND keluarga.family_relation_id = family_relation.id\n"
        + "AND keluarga.education_level_id = education_level.id\n" + "AND keluarga.biodata_id = biodata.id\n"
        + "AND family_relation.family_tree_type_id = family_tree_type.id\n" + "AND keluarga.isdelete = false\n"
        + "AND biodata.id=:biodataId")

@Entity
@Table(name = "x_keluarga")
public class KeluargaEntityRio extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private int biodataId;

    @Column(name = "family_tree_type_id")
    private Long familyTreeTypeId;

    @Column(name = "family_relation_id")
    private Long familyRelationId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender", nullable = false)
    private Boolean gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+07:00")
    @Column(name = "dob")
    private Date dob;

    @Column(name = "education_level_id")
    private Long educationLevelId;

    @Column(name = "job")
    private String job;

    @Column(name = "notes")
    private String notes;

    public KeluargaEntityRio() {
    }

    public KeluargaEntityRio(int biodataId, Long familyTreeTypeId, Long familyRelationId, String name, Boolean gender,
            Date dob, Long educationLevelId, String job, String notes) {
        this.biodataId = biodataId;
        this.familyTreeTypeId = familyTreeTypeId;
        this.familyRelationId = familyRelationId;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.educationLevelId = educationLevelId;
        this.job = job;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(int biodataId) {
        this.biodataId = biodataId;
    }

    public Long getFamilyTreeTypeId() {
        return familyTreeTypeId;
    }

    public void setFamilyTreeTypeId(Long familyTreeTypeId) {
        this.familyTreeTypeId = familyTreeTypeId;
    }

    public Long getFamilyRelationId() {
        return familyRelationId;
    }

    public void setFamilyRelationId(Long familyRelationId) {
        this.familyRelationId = familyRelationId;
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

    public Long getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
