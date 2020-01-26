package com.xsis.xsis.model.dhika;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * Client
 */
@Entity
@Table(name = "x_client")
public class ClientDika extends CommonEntity {

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

    @ManyToOne
    @JoinColumn(name = "ero", nullable = false, referencedColumnName = "id")
    private EmployeeDika ero;

    @Column(name = "user_email")
    @Size(max = 100)
    private String userEmail;

    public ClientDika() {

    }

    public ClientDika(Long id, @Size(max = 100) String name, @Size(max = 100) String userClientName, EmployeeDika ero,
            @Size(max = 100) String userEmail) {
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

    public EmployeeDika getEro() {
        return ero;
    }

    public void setEro(EmployeeDika ero) {
        this.ero = ero;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}