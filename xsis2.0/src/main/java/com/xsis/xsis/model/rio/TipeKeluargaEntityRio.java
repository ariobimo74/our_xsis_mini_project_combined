package com.xsis.xsis.model.rio;


import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;


@Entity
@Table(name = "x_family_tree_type")
public class TipeKeluargaEntityRio extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public TipeKeluargaEntityRio() {
    }

    public TipeKeluargaEntityRio(String name, String description) {
        this.name = name;
        this.description = description;
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
}
