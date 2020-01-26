package com.xsis.xsis.dto.fia;

/**
 * KeteraganBioDto
 */
public class KeteranganBioDtoAlfia {

    public Long id;
    public Boolean isdelete;
    public Long biodataId;
    public String expected_salary;
    public Boolean is_negotiable;
    public String start_working;
    public Boolean is_ready_to_outoftown;
    public String emergency_contact_name;
    public String emergency_contact_phone;

    public KeteranganBioDtoAlfia() {
    }

    public KeteranganBioDtoAlfia(Long id, Boolean isdelete, Long biodataId, String expected_salary,
            Boolean is_negotiable, String start_working, Boolean is_ready_to_outoftown, String emergency_contact_name,
            String emergency_contact_phone) {
        this.id = id;
        this.isdelete = isdelete;
        this.biodataId = biodataId;
        this.expected_salary = expected_salary;
        this.is_negotiable = is_negotiable;
        this.start_working = start_working;
        this.is_ready_to_outoftown = is_ready_to_outoftown;
        this.emergency_contact_name = emergency_contact_name;
        this.emergency_contact_phone = emergency_contact_phone;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isIsdelete() {
        return this.isdelete;
    }

    public Boolean getIsdelete() {
        return this.isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Long getBiodataId() {
        return this.biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public String getExpected_salary() {
        return this.expected_salary;
    }

    public void setExpected_salary(String expected_salary) {
        this.expected_salary = expected_salary;
    }

    public Boolean isIs_negotiable() {
        return this.is_negotiable;
    }

    public Boolean getIs_negotiable() {
        return this.is_negotiable;
    }

    public void setIs_negotiable(Boolean is_negotiable) {
        this.is_negotiable = is_negotiable;
    }

    public String getStart_working() {
        return this.start_working;
    }

    public void setStart_working(String start_working) {
        this.start_working = start_working;
    }

    public Boolean isIs_ready_to_outoftown() {
        return this.is_ready_to_outoftown;
    }

    public Boolean getIs_ready_to_outoftown() {
        return this.is_ready_to_outoftown;
    }

    public void setIs_ready_to_outoftown(Boolean is_ready_to_outoftown) {
        this.is_ready_to_outoftown = is_ready_to_outoftown;
    }

    public String getEmergency_contact_name() {
        return this.emergency_contact_name;
    }

    public void setEmergency_contact_name(String emergency_contact_name) {
        this.emergency_contact_name = emergency_contact_name;
    }

    public String getEmergency_contact_phone() {
        return this.emergency_contact_phone;
    }

    public void setEmergency_contact_phone(String emergency_contact_phone) {
        this.emergency_contact_phone = emergency_contact_phone;
    }

}