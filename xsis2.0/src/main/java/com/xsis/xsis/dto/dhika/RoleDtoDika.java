package com.xsis.xsis.dto.dhika;

/**
 * RoleDto
 */
public class RoleDtoDika {

    private Long id;
    private Boolean isDelete;
    private String code;
    private String name;

    public RoleDtoDika() {

    }

    public RoleDtoDika(Long id, Boolean isDelete, String code, String name) {
        this.id = id;
        this.isDelete = isDelete;
        this.code = code;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

}