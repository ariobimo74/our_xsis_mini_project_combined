package com.xsis.xsis.dto.vac_prof_respro;

/**
 * LastEduDto
 */
public class LastEduDto {

    private String schoolName;
    private String major;

    public LastEduDto() {
    }

    public LastEduDto(String schoolName, String major) {
        this.schoolName = schoolName;
        this.major = major;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}