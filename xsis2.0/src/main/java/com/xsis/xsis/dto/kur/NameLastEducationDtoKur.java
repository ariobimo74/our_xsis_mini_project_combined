package com.xsis.xsis.dto.kur;

/**
 * NameLastEducationDto
 */
public class NameLastEducationDtoKur {
    private Boolean isDelete;
    private Long educationLevelId;
    private Long biodataId;
    private String schoolName;
    private String graduationYear;
    private String major;

    public NameLastEducationDtoKur(Boolean isDelete, Long educationLevelId, Long biodataId, String schoolName,
            String graduationYear, String major) {
        this.isDelete = isDelete;
        this.educationLevelId = educationLevelId;
        this.biodataId = biodataId;
        this.schoolName = schoolName;
        this.graduationYear = graduationYear;
        this.major = major;
    }

    public NameLastEducationDtoKur() {
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
     * @return Long return the educationLevelId
     */
    public Long getEducationLevelId() {
        return educationLevelId;
    }

    /**
     * @param educationLevelId the educationLevelId to set
     */
    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
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
     * @return String return the schoolName
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * @param schoolName the schoolName to set
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * @return String return the graduationYear
     */
    public String getGraduationYear() {
        return graduationYear;
    }

    /**
     * @param graduationYear the graduationYear to set
     */
    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    /**
     * @return String return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

}