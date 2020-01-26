package com.xsis.xsis.model.fathan;

import javax.persistence.*;

import com.xsis.xsis.dto.fathan.OrganisasiDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "organisasiMapping", classes = { @ConstructorResult(targetClass = OrganisasiDto.class, columns = { 
                @ColumnResult(name = "id", type = Long.class),
                @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "biodata_id", type = Long.class),
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "position", type = String.class),
                @ColumnResult(name = "entry_year", type = String.class),
                @ColumnResult(name = "exit_year", type = String.class)}) })

// List Category Join Brand
@NamedNativeQuery(name = "Organisasi.getBioId", 
query = "select a.id,a.isdelete,a.biodata_id,a.name,a.position,a.entry_year,a.exit_year" + 
" from x_organisasi a where a.biodata_id=:biodataId and a.isdelete=false", resultSetMapping = "organisasiMapping")
/**
 * Organisasi
 */
@Entity
@Table(name = "x_organisasi")
public class Organisasi extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "entry_year")
    private String entryYear;

    @Column(name = "exit_year")
    private String exitYear;

    @Column(name = "responsibility")
    private String responsibility;

    @Column(name = "notes")
    private String notes;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Long return the biodataId
     */
    public Long getBiodataId() {
        return biodataId;
    }

    /**
     * @param biodataId the biodataId to set
     */
    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return String return the entryYear
     */
    public String getEntryYear() {
        return entryYear;
    }

    /**
     * @param entryYear the entryYear to set
     */
    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    /**
     * @return String return the exitYear
     */
    public String getExitYear() {
        return exitYear;
    }

    /**
     * @param exitYear the exitYear to set
     */
    public void setExitYear(String exitYear) {
        this.exitYear = exitYear;
    }

    /**
     * @return String return the responsibility
     */
    public String getResponsibility() {
        return responsibility;
    }

    /**
     * @param responsibility the responsibility to set
     */
    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    /**
     * @return String return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

}