package com.xsis.xsis.dto.rio;

public class KeahlianDtoRio {
    private Long id;
    private Boolean isDelete;
    private Long biodataId;
    private String skillName;
    private Long skillLevelId;
    private String notes;
    private String name;
    private String fullname;

    public KeahlianDtoRio() {
    }

    public KeahlianDtoRio(Long id, Boolean isDelete, Long biodataId, String skillName, Long skillLevelId) {
        this.id = id;
        this.isDelete = isDelete;
        this.biodataId = biodataId;
        this.skillName = skillName;
        this.skillLevelId = skillLevelId;
    }

    public KeahlianDtoRio(Long id, Boolean isDelete, Long biodataId, String skillName, Long skillLevelId, String notes,
            String name, String fullname) {
        this.id = id;
        this.isDelete = isDelete;
        this.biodataId = biodataId;
        this.skillName = skillName;
        this.skillLevelId = skillLevelId;
        this.notes = notes;
        this.name = name;
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
