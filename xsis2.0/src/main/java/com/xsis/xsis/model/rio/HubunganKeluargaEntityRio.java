package com.xsis.xsis.model.rio;

import com.xsis.xsis.dto.rio.HubunganKeluargaDtoRio;
import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;

@SqlResultSetMapping(name = "hubunganKeluargaMapping", classes = {
        @ConstructorResult(targetClass = HubunganKeluargaDtoRio.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "type", type = String.class),
                @ColumnResult(name = "relation", type = String.class),
                @ColumnResult(name = "isdelete", type = Boolean.class) }) })

@NamedNativeQuery(name = "HubunganKeluargaEntityRio.getTipeId", resultSetMapping = "hubunganKeluargaMapping", query = "SELECT family_relation.id, family_tree_type.name AS type, family_relation.name AS relation, family_tree_type.isdelete\n"
        + "FROM x_family_tree_type AS family_tree_type, x_family_relation AS family_relation\n"
        + "WHERE family_relation.family_tree_type_id = family_tree_type.id\n"
        + "AND family_tree_type.isdelete = false \n" + "AND family_relation.family_tree_type_id=:familyTreeTypeId")

@Entity
@Table(name = "x_family_relation")
public class HubunganKeluargaEntityRio extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "family_tree_type_id")
    private Long familyTreeTypeId;

    public HubunganKeluargaEntityRio() {
    }

    public HubunganKeluargaEntityRio(String name, String description, Long familyTreeTypeId) {
        this.name = name;
        this.description = description;
        this.familyTreeTypeId = familyTreeTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFamilyTreeTypeId() {
        return familyTreeTypeId;
    }

    public void setFamilyTreeTypeId(Long familyTreeTypeId) {
        this.familyTreeTypeId = familyTreeTypeId;
    }
}
