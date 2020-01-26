package com.xsis.xsis.dto.fathan;

/**
 * TestTypeDto
 */
public class OnlineTestDetailDto {
    public Long id;
    public Boolean isdelete;
    public Long onlineTestId;
    public String name;

    public OnlineTestDetailDto(){

    }
    public OnlineTestDetailDto(Long id, Boolean isdelete, Long onlineTestId, String name) {
        this.id = id;
        this.isdelete = isdelete;
        this.onlineTestId = onlineTestId;
        this.name = name;
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

    public Long getOnlineTestId() {
        return onlineTestId;
    }

    public void setOnlineTestId(Long onlineTestId) {
        this.onlineTestId = onlineTestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}