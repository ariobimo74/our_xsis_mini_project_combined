package com.xsis.xsis.model.dhika;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.xsis.xsis.dto.dhika.RoleDtoDika;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "roleMapping", classes = { @ConstructorResult(targetClass = RoleDtoDika.class, columns = {
        @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "isdelete", type = boolean.class),
        @ColumnResult(name = "code", type = String.class), @ColumnResult(name = "name", type = String.class) }) })

@NamedNativeQuery(name = "RoleDika.getRoleAll", query = "SELECT a.id, a.isdelete, a.code, a.name FROM x_role a WHERE a.isdelete = false ORDER BY a.code", resultSetMapping = "roleMapping")

/**
 * Role
 */
@Entity
@Table(name = "x_role")
public class RoleDika extends CommonEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    public RoleDika() {

    }

    public RoleDika(Long id, String code, String name) {
        this.id = id;
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

}