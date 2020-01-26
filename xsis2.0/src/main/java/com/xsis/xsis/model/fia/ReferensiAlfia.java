package com.xsis.xsis.model.fia;

import javax.persistence.*;

import com.xsis.xsis.dto.fia.ReferensiBioDtoAlfia;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "referensiAlfiaMapping", classes = {
        @ConstructorResult(targetClass = ReferensiBioDtoAlfia.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "isdelete", type = Boolean.class),
                @ColumnResult(name = "biodata_id", type = Long.class),
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "position", type = String.class),
                @ColumnResult(name = "address_phone", type = String.class),
                @ColumnResult(name = "relation", type = String.class), }) })

@NamedNativeQuery(name = "ReferensiAlfia.getBioId", query = "select a.id,a.isdelete,a.biodata_id,a.name,a.position,a.address_phone,a.relation"
        + " from x_pe_referensi a where a.biodata_id=:biodataId and a.isdelete=false", resultSetMapping = "referensiAlfiaMapping")

@Entity
@Table(name = "x_pe_referensi")
public class ReferensiAlfia extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private Long biodataId;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "address_phone")
    private String addressPhone;

    @Column(name = "relation")
    private String relation;

    public ReferensiAlfia() {
    }

    public ReferensiAlfia(Long biodataId, String name, String position, String addressPhone, String relation) {
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