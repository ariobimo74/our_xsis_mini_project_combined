package com.xsis.xsis.dto.fathan;

/**
 * OrganisasiDto
 */
public class OrganisasiDto {

    public Long id;
    public Boolean isdelete;
    public Long biodataId;
    public String name;
    public String position;
    public String entry_year;
    public String exit_year;

    public OrganisasiDto(){}

    public OrganisasiDto(Long id, Boolean isdelete, Long biodataId, String name, String position, String entry_year,
            String exit_year) {
        this.id = id;
        this.isdelete = isdelete;
        this.biodataId = biodataId;
        this.name = name;
        this.position = position;
        this.entry_year = entry_year;
        this.exit_year = exit_year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEntry_year() {
        return entry_year;
    }

    public void setEntry_year(String entry_year) {
        this.entry_year = entry_year;
    }

    public String getExit_year() {
        return exit_year;
    }

    public void setExit_year(String exit_year) {
        this.exit_year = exit_year;
    }

    

}