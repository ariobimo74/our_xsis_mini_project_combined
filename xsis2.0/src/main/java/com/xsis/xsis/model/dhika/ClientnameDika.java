package com.xsis.xsis.model.dhika;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;

/**
 * Clientname
 */
@Entity
@Immutable
@Table(name = "x_clientname")
public class ClientnameDika {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

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

}