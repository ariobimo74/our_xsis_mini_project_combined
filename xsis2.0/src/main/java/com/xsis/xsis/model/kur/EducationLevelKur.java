package com.xsis.xsis.model.kur;

import javax.persistence.*;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * LevelPendidikan
 */
@Entity
@Table(name = "x_education_level")
public class EducationLevelKur extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public EducationLevelKur() {
    }

    public EducationLevelKur(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}