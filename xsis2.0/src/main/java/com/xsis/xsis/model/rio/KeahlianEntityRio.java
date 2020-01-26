package com.xsis.xsis.model.rio;

import com.xsis.xsis.dto.rio.KeahlianDtoRio;
import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;

@SqlResultSetMapping(name = "keahlianMappingRio", classes = {
        @ConstructorResult(targetClass = KeahlianDtoRio.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "biodata_id", type = Long.class),
                @ColumnResult(name = "skill_name", type = String.class),
                @ColumnResult(name = "skill_level_id", type = Long.class),
                @ColumnResult(name = "notes", type = String.class), @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "fullname", type = String.class) }) })

@NamedNativeQuery(name = "KeahlianEntityRio.getBioId", query = "SELECT x.id, x.isdelete, x.biodata_id, x.skill_name, x.skill_level_id, x.notes, y.name, z.fullname "
        + "FROM x_keahlian x JOIN x_skill_level y ON x.skill_level_id = y.id AND x.biodata_id=:biodataId JOIN x_biodata z ON x.biodata_id = z.id AND x.isdelete = false", resultSetMapping = "keahlianMappingRio")

@Entity
@Table(name = "x_keahlian")
public class KeahlianEntityRio extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private Long biodataId;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_level_id")
    private Long skillLevelId;

    @Column(name = "notes")
    private String notes;

    public KeahlianEntityRio() {
    }

    public KeahlianEntityRio(Long biodataId, String skillName, Long skillLevelId, String notes) {
        this.biodataId = biodataId;
        this.skillName = skillName;
        this.skillLevelId = skillLevelId;
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

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Long getSkillLevelId() {
        return skillLevelId;
    }

    public void setSkillLevelId(Long skillLevelId) {
        this.skillLevelId = skillLevelId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
