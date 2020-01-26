package com.xsis.xsis.model.kur;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.xsis.xsis.models.common.CommonEntity;

@Entity
@Table(name = "x_schedule_type")
public class ScheduleTypeKur extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(max = 50)
    private String name;

    @Column(name = "description")
    @Size(max = 100)
    private String description;

    public ScheduleTypeKur(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ScheduleTypeKur() {
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
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}