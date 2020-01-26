package com.xsis.xsis.dto.rio;

public class HubunganKeluargaDtoRio
{
    private Long id;
    private String type;
    private String relation;
    private Boolean isDelete;

    public HubunganKeluargaDtoRio() {
    }

    public HubunganKeluargaDtoRio(Long id, String type, String relation, Boolean isDelete) {
        this.id = id;
        this.type = type;
        this.relation = relation;
        this.isDelete = isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
