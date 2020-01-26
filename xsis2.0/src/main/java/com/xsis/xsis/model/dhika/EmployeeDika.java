package com.xsis.xsis.model.dhika;

import javax.persistence.*;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * Employee
 */
@Entity
@Table(name = "x_employee")
public class EmployeeDika extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "biodata_id", nullable = false, referencedColumnName = "id")
    private BiodataDika biodataId;

    @Column(name = "is_idle")
    private boolean isIdle;

    @Column(name = "is_ero")
    private boolean isEro;

    @Column(name = "is_user_client")
    private boolean isUserClient;

    @Column(name = "ero_email")
    private String eroEmail;

    public EmployeeDika() {

    }

    public EmployeeDika(Long id, BiodataDika biodataId, boolean isIdle, boolean isEro, boolean isUserClient, String eroEmail) {
        this.id = id;
        this.biodataId = biodataId;
        this.isIdle = isIdle;
        this.isEro = isEro;
        this.isUserClient = isUserClient;
        this.eroEmail = eroEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BiodataDika getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(BiodataDika biodataId) {
        this.biodataId = biodataId;
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void setIdle(boolean isIdle) {
        this.isIdle = isIdle;
    }

    public boolean isEro() {
        return isEro;
    }

    public void setEro(boolean isEro) {
        this.isEro = isEro;
    }

    public boolean isUserClient() {
        return isUserClient;
    }

    public void setUserClient(boolean isUserClient) {
        this.isUserClient = isUserClient;
    }

    public String getEroEmail() {
        return eroEmail;
    }

    public void setEroEmail(String eroEmail) {
        this.eroEmail = eroEmail;
    }

}