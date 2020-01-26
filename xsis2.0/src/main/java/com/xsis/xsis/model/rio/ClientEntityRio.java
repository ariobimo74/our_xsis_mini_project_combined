package com.xsis.xsis.model.rio;

import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;

@Entity
@Table(name = "x_client")
public class ClientEntityRio extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_client_name", nullable = false)
    private String userClientName;

    @Column(name = "ero", nullable = false)
    private Long ero;

    @Column(name = "user_email")
    private String userEmail;

    public ClientEntityRio() {
    }

    public ClientEntityRio(Long id, String name, String userClientName,  Long ero, String userEmail)
    {
        this.id = id;
        this.name = name;
        this.userClientName = userClientName;
        this.ero = ero;
        this.userEmail = userEmail;
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

    public String getUserClientName() {
        return userClientName;
    }

    public void setUserClientName(String userClientName) {
        this.userClientName = userClientName;
    }

    public Long getEro() {
        return ero;
    }

    public void setEro(Long ero) {
        this.ero = ero;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
