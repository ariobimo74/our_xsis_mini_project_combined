package com.xsis.xsis.dto.fia;

public class SertifikasiDtoAlfia {

    private Long id;
    private Long biodataId;
    private String certificateName;
    private String publisher;
    private String validStartYear;
    private String validStartMonth;
    private String untilYear;
    private String untilMonth;
    private String notes;

    public SertifikasiDtoAlfia(Long id, Long biodataId, String certificateName, String publisher, String validStartYear,
            String validStartMonth, String untilYear, String untilMonth, String notes) {
        this.id = id;
        this.biodataId = biodataId;
        this.certificateName = certificateName;
        this.publisher = publisher;
        this.validStartYear = validStartYear;
        this.validStartMonth = validStartMonth;
        this.untilYear = untilYear;
        this.untilMonth = untilMonth;
        this.notes = notes;
    }

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
     * @return String return the certificateName
     */
    public String getCertificateName() {
        return certificateName;
    }

    /**
     * @param certificateName the certificateName to set
     */
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    /**
     * @return String return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return String return the validStartYear
     */
    public String getValidStartYear() {
        return validStartYear;
    }

    /**
     * @param validStartYear the validStartYear to set
     */
    public void setValidStartYear(String validStartYear) {
        this.validStartYear = validStartYear;
    }

    /**
     * @return String return the validStartMonth
     */
    public String getValidStartMonth() {
        return validStartMonth;
    }

    /**
     * @param validStartMonth the validStartMonth to set
     */
    public void setValidStartMonth(String validStartMonth) {
        this.validStartMonth = validStartMonth;
    }

    /**
     * @return String return the untilYear
     */
    public String getUntilYear() {
        return untilYear;
    }

    /**
     * @param untilYear the untilYear to set
     */
    public void setUntilYear(String untilYear) {
        this.untilYear = untilYear;
    }

    /**
     * @return String return the untilMonth
     */
    public String getUntilMonth() {
        return untilMonth;
    }

    /**
     * @param untilMonth the untilMonth to set
     */
    public void setUntilMonth(String untilMonth) {
        this.untilMonth = untilMonth;
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