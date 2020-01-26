package com.xsis.xsis.model.fia;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.xsis.xsis.models.common.CommonEntity;

@Entity
@Table(name = "x_client")
public class ClientAlfia extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @Size(max = 100)
    private String name;

    @Column(name = "user_client_name")
    @Size(max = 100)
    private String userClientName;

    @Column(name = "ero")
    private Long ero;

    @Column(name = "user_email")
    @Size(max = 100)
    private String userEmail;

    public ClientAlfia() {
    }

    public ClientAlfia(String name, String userClientName, Long ero, String userEmail) {
        this.name = name;
        this.userClientName = userClientName;
        this.ero = ero;
        this.userEmail = userEmail;
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

    public String getUserClientName() {
        return this.userClientName;
    }

    public void setUserClientName(String userClientName) {
        this.userClientName = userClientName;
    }

    public Long getEro() {
        return this.ero;
    }

    public void setEro(Long ero) {
        this.ero = ero;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}