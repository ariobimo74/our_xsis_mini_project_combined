package com.xsis.xsis.model.kur;

import javax.persistence.Entity;

import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;

/**
 * Employee
 */
@Entity
@Table(name = "x_employee")
public class EmployeeKur extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "biodata_id", referencedColumnName = "id")
    private BiodataKur biodataId;

    @Column(name = "is_idle")
    private Boolean isIdle = false;

    @Column(name = "is_ero")
    private Boolean isEro = false;

    @Column(name = "is_user_client")
    private Boolean isUserClient = false;

    @Column(name = "ero_email")
    private Boolean eroEmail = false;

    public EmployeeKur() {
    }

    public EmployeeKur(BiodataKur biodataId, Boolean isIdle, Boolean isEro, Boolean isUserClient, Boolean eroEmail) {
        this.biodataId = biodataId;
        this.isIdle = isIdle;
        this.isEro = isEro;
        this.isUserClient = isUserClient;
        this.eroEmail = eroEmail;
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
     * @return Biodata return the biodataId
     */
    public BiodataKur getBiodataId() {
        return biodataId;
    }

    /**
     * @param biodataId the biodataId to set
     */
    public void setBiodataId(BiodataKur biodataId) {
        this.biodataId = biodataId;
    }

    /**
     * @return Boolean return the isIdle
     */
    public Boolean isIsIdle() {
        return isIdle;
    }

    /**
     * @param isIdle the isIdle to set
     */
    public void setIsIdle(Boolean isIdle) {
        this.isIdle = isIdle;
    }

    /**
     * @return Boolean return the isEro
     */
    public Boolean isIsEro() {
        return isEro;
    }

    /**
     * @param isEro the isEro to set
     */
    public void setIsEro(Boolean isEro) {
        this.isEro = isEro;
    }

    /**
     * @return Boolean return the isUserClient
     */
    public Boolean isIsUserClient() {
        return isUserClient;
    }

    /**
     * @param isUserClient the isUserClient to set
     */
    public void setIsUserClient(Boolean isUserClient) {
        this.isUserClient = isUserClient;
    }

    /**
     * @return Boolean return the eroEmail
     */
    public Boolean isEroEmail() {
        return eroEmail;
    }

    /**
     * @param eroEmail the eroEmail to set
     */
    public void setEroEmail(Boolean eroEmail) {
        this.eroEmail = eroEmail;
    }

}