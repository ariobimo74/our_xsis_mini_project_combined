package com.xsis.xsis.dto.rio;

public class CatatanDtoRio {
    private Long id;
    private Boolean isDelete;
    private Long biodataId;
    private String title;
    private Long noteTypeId;
    private Long createdBy;
    private String name;
    private String fullname;

    public CatatanDtoRio() {
    }

    public CatatanDtoRio(Long id, Boolean isDelete, Long biodataId, String title, Long noteTypeId, Long createdBy) {
        this.id = id;
        this.isDelete = isDelete;
        this.biodataId = biodataId;
        this.title = title;
        this.noteTypeId = noteTypeId;
        this.createdBy = createdBy;
    }

    public CatatanDtoRio(Long id, Boolean isDelete, Long biodataId, String title, Long noteTypeId, Long createdBy,
            String name) {
        this.id = id;
        this.isDelete = isDelete;
        this.biodataId = biodataId;
        this.title = title;
        this.noteTypeId = noteTypeId;
        this.createdBy = createdBy;
        this.name = name;
    }

    public CatatanDtoRio(Long id, Boolean isDelete, Long biodataId, String title, Long noteTypeId, Long createdBy,
            String name, String fullname) {
        this.id = id;
        this.isDelete = isDelete;
        this.biodataId = biodataId;
        this.title = title;
        this.noteTypeId = noteTypeId;
        this.createdBy = createdBy;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getNoteTypeId() {
        return noteTypeId;
    }

    public void setNoteTypeId(Long noteTypeId) {
        this.noteTypeId = noteTypeId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
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
