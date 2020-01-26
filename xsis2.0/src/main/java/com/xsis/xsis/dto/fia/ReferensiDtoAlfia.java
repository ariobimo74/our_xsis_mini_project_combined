package com.xsis.xsis.dto.fia;

/**
 * ReferensiDto
 */
public class ReferensiDtoAlfia {

    private Long id;
    private Long biodataId;
    private String name;
    private String position;
    private String addressPhone;
    private String relation;

    public ReferensiDtoAlfia(Long id, Long biodataId, String name, String position, String addressPhone,
            String relation) {
        this.id = id;
        this.biodataId = biodataId;
        this.name = name;
        this.position = position;
        this.addressPhone = addressPhone;
        this.relation = relation;
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
     * @return String return the addressPhone
     */
    public String getAddressPhone() {
        return addressPhone;
    }

    /**
     * @param addressPhone the addressPhone to set
     */
    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    /**
     * @return String return the relation
     */
    public String getRelation() {
        return relation;
    }

    /**
     * @param relation the relation to set
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

}