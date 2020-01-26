package com.xsis.xsis.model.rio;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "x_biodata")
public class BiodataEntityRio extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private int biodataId;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "token")
    @Size(max = 10)
    private String token;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "expired_token")
    private Date expiredToken;

    @Column(name = "email", nullable = false)
    @Size(max = 100)
    private String email;

    public BiodataEntityRio(){}

    public BiodataEntityRio(int biodataId, String fullName, @Size(max = 10) String token, Date expiredToken, @Size(max = 100) String email) {
        this.biodataId = biodataId;
        this.fullName = fullName;
        this.token = token;
        this.expiredToken = expiredToken;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(int biodataId) {
        this.biodataId = biodataId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiredToken() {
        return expiredToken;
    }

    public void setExpiredToken(Date expiredToken) {
        this.expiredToken = expiredToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
