package com.xsis.xsis.dto.fia;

public class BiodataPengkerDtoAlfia {
    private long id;
    private Boolean isDelete;
    private long biodataId;
    private String companyName;
    private String joinYear;
    private String joinMonth;
    private String resignYear;
    private String resignMonth;
    private String notes;

    public BiodataPengkerDtoAlfia() {
    }

    public BiodataPengkerDtoAlfia(long id, Boolean isDelete, long biodataId, String companyName, String joinYear,
            String joinMonth, String resignYear, String resignMonth, String notes) {
        this.id = id;
        this.isDelete = isDelete;
        this.biodataId = biodataId;
        this.companyName = companyName;
        this.joinYear = joinYear;
        this.joinMonth = joinMonth;
        this.resignYear = resignYear;
        this.resignMonth = resignMonth;
        this.notes = notes;
    }

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return Boolean return the isDelete
     */
    public Boolean isIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete the isDelete to set
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return long return the biodataId
     */
    public long getBiodataId() {
        return biodataId;
    }

    /**
     * @param biodataId the biodataId to set
     */
    public void setBiodataId(long biodataId) {
        this.biodataId = biodataId;
    }

    /**
     * @return String return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return String return the joinYear
     */
    public String getJoinYear() {
        return joinYear;
    }

    /**
     * @param joinYear the joinYear to set
     */
    public void setJoinYear(String joinYear) {
        this.joinYear = joinYear;
    }

    /**
     * @return String return the joinMonth
     */
    public String getJoinMonth() {
        return joinMonth;
    }

    /**
     * @param joinMonth the joinMonth to set
     */
    public void setJoinMonth(String joinMonth) {
        this.joinMonth = joinMonth;
    }

    /**
     * @return String return the resignYear
     */
    public String getResignYear() {
        return resignYear;
    }

    /**
     * @param resignYear the resignYear to set
     */
    public void setResignYear(String resignYear) {
        this.resignYear = resignYear;
    }

    /**
     * @return String return the resignMonth
     */
    public String getResignMonth() {
        return resignMonth;
    }

    /**
     * @param resignMonth the resignMonth to set
     */
    public void setResignMonth(String resignMonth) {
        this.resignMonth = resignMonth;
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