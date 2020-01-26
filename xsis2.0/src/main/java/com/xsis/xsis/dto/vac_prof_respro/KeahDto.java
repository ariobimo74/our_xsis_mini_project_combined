package com.xsis.xsis.dto.vac_prof_respro;

/**
 * KeahDto
 */
public class KeahDto {

    private Long id;
    private Long biodataId;
    private String skillName;
    private Long skillLevelId;

    public KeahDto() {
    }

    public KeahDto(Long id, Long biodataId, String skillName, Long skillLevelId) {
        this.id = id;
        this.biodataId = biodataId;
        this.skillName = skillName;
        this.skillLevelId = skillLevelId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBiodataId() {
        return this.biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public String getSkillName() {
        return this.skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Long getSkillLevelId() {
        return this.skillLevelId;
    }

    public void setSkillLevelId(Long skillLevelId) {
        this.skillLevelId = skillLevelId;
    }

}