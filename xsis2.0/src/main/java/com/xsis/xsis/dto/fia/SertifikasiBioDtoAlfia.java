package com.xsis.xsis.dto.fia;

/**
 * SertifikasiBioDto
 */
public class SertifikasiBioDtoAlfia {

    public Long id;
    public Boolean isdelete;
    public Long biodataId;
    public String certificate_name;
    public String publisher;
    public String valid_start_year;
    public String valid_start_month;
    public String until_year;
    public String until_month;

    public SertifikasiBioDtoAlfia() {

    }

    public SertifikasiBioDtoAlfia(Long id, Boolean isdelete, Long biodataId, String certificate_name, String publisher,
            String valid_start_year, String valid_start_month, String until_year, String until_month) {
        this.id = id;
        this.isdelete = isdelete;
        this.biodataId = biodataId;
        this.certificate_name = certificate_name;
        this.publisher = publisher;
        this.valid_start_year = valid_start_year;
        this.valid_start_month = valid_start_month;
        this.until_year = until_year;
        this.until_month = until_month;
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

    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getValid_start_year() {
        return valid_start_year;
    }

    public void setValid_start_year(String valid_start_year) {
        this.valid_start_year = valid_start_year;
    }

    public String getValid_start_month() {
        return valid_start_month;
    }

    public void setValid_start_month(String valid_start_month) {
        this.valid_start_month = valid_start_month;
    }

    public String getUntil_year() {
        return until_year;
    }

    public void setUntil_year(String until_year) {
        this.until_year = until_year;
    }

    public String getUntil_month() {
        return until_month;
    }

    public void setUntil_month(String until_month) {
        this.until_month = until_month;
    }

}