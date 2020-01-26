package com.xsis.xsis.dto.fathan;

/**
 * DokumenDto
 */
public class DokumenDto {
    public Long id;
    public Boolean isdelete;
    public Long biodataId;
    public String fileName;
    public String notes;

    public DokumenDto(){
        
    }

    public DokumenDto(Long id, Boolean isdelete, Long biodataId, String fileName, String notes) {
        this.id = id;
        this.isdelete = isdelete;
        this.biodataId = biodataId;
        this.fileName = fileName;
        this.notes = notes;
    }
    
    public Long getId() {
        return id;
    }

    public void setIdDoc(Long id) {
        this.id = id;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Long getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }    
}