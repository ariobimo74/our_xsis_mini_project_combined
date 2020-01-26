package com.xsis.xsis.dto.vac_prof_respro;

/**
 * SertDto
 */
public class SertDto {

    private Long id;
    private Long biodataId;
    private String certificateName;
    private String publisher;
    private String validStartYear;
    private String untilYear;

    public SertDto() {
    }

    public SertDto(Long id, Long biodataId, String certificateName, String publisher, String validStartYear,
            String untilYear) {
        this.id = id;
        this.biodataId = biodataId;
        this.certificateName = certificateName;
        this.publisher = publisher;
        this.validStartYear = validStartYear;
        this.untilYear = untilYear;
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

    public String getCertificateName() {
        return this.certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getValidStartYear() {
        return this.validStartYear;
    }

    public void setValidStartYear(String validStartYear) {
        this.validStartYear = validStartYear;
    }

    public String getUntilYear() {
        return this.untilYear;
    }

    public void setUntilYear(String untilYear) {
        this.untilYear = untilYear;
    }

}