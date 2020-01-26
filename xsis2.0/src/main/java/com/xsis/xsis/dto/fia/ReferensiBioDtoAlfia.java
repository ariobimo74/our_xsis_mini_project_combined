package com.xsis.xsis.dto.fia;

/**
 * ReferensiBioDto
 */
public class ReferensiBioDtoAlfia {

    public Long id;
    public Boolean isdelete;
    public Long biodataId;
    public String name;
    public String position;
    public String address_phone;
    public String relation;

    public ReferensiBioDtoAlfia() {
    }

    public ReferensiBioDtoAlfia(Long id, Boolean isdelete, Long biodataId, String name, String position,
            String address_phone, String relation) {
        this.id = id;
        this.isdelete = isdelete;
        this.biodataId = biodataId;
        this.name = name;
        this.position = position;
        this.address_phone = address_phone;
        this.relation = relation;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress_phone() {
        return this.address_phone;
    }

    public void setAddress_phone(String address_phone) {
        this.address_phone = address_phone;
    }

    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

}