package com.xsis.xsis.model.rio;

import com.xsis.xsis.dto.rio.CatatanDtoRio;
import com.xsis.xsis.models.common.CommonEntity;
import javax.persistence.*;

@SqlResultSetMapping(name = "catatanMapping", classes = {
        @ConstructorResult(targetClass = CatatanDtoRio.class, columns = { @ColumnResult(name = "id", type = Long.class),
                @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "biodata_id", type = Long.class),
                @ColumnResult(name = "title", type = String.class),
                @ColumnResult(name = "note_type_id", type = Long.class),
                @ColumnResult(name = "created_by", type = Long.class),
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "fullname", type = String.class) }) })

@NamedNativeQuery(name = "CatatanEntityRio.getBioId", query = "SELECT x.id, x.isdelete, x.biodata_id, x.title, x.note_type_id, x.created_by, y.name, z.fullname"
        + " FROM x_catatan x JOIN x_note_type y ON x.biodata_id=:biodataId AND x.note_type_id = y.id JOIN x_biodata z ON x.biodata_id = z.id AND x.isdelete = false", resultSetMapping = "catatanMapping")

@Entity
@Table(name = "x_catatan")
public class CatatanEntityRio extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private Long biodataId;

    @Column(name = "title")
    private String title;

    @Column(name = "note_type_id")
    private Long noteTypeId;

    @Column(name = "notes")
    private String notes;

    public CatatanEntityRio() {
    }

    public CatatanEntityRio(Long biodataId, String title, Long noteTypeId, String notes) {
        this.biodataId = biodataId;
        this.title = title;
        this.noteTypeId = noteTypeId;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
