package com.xsis.xsis.model.fathan;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.xsis.xsis.dto.fathan.DokumenDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "dokumenMapping", classes = {@ConstructorResult(targetClass = DokumenDto.class, columns = {
    @ColumnResult(name = "id" , type = Long.class),
    @ColumnResult(name = "isdelete" , type = Boolean.class),
    @ColumnResult(name = "biodata_id" , type = Long.class),
    @ColumnResult(name = "file_name" , type = String.class),
    @ColumnResult(name = "notes" , type = String.class)
})})

@NamedNativeQuery(name = "Dokumen.getBioId",
    query = "select id,isdelete,biodata_id,file_name,notes"
    +" from x_biodata_attachment where biodata_id=:biodataId and isdelete=false", resultSetMapping = "dokumenMapping")
/**
 * Dokumen
 */
@Entity
@Table(name = "x_biodata_attachment")
public class Dokumen extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "notes")
    private String notesDoc;

    @Column(name = "is_photo")
    private Boolean isPhoto;

    public Long getId() {
        return id;
    }

    public void setIdDoc(Long id) {
        this.id = id;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getNotesDoc() {
        return notesDoc;
    }

    public void setNotesDoc(String notesDoc) {
        this.notesDoc = notesDoc;
    }

    public Boolean getIsPhoto() {
        return isPhoto;
    }

    public void setIsPhoto(Boolean isPhoto) {
        this.isPhoto = isPhoto;
    }

    
}