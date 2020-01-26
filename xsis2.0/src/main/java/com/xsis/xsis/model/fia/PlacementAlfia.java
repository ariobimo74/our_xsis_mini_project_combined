package com.xsis.xsis.model.fia;

import javax.persistence.*;

import com.xsis.xsis.models.common.CommonEntity;

@Entity
@Table(name = "x_placement")
public class PlacementAlfia extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "is_placement_active", nullable = false)
    private Boolean isPlacementActive;

    public PlacementAlfia() {
    }

    public PlacementAlfia(Long clientId, Long employeeId, Boolean isPlacementActive) {
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.isPlacementActive = isPlacementActive;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean isIsPlacementActive() {
        return this.isPlacementActive;
    }

    public Boolean getIsPlacementActive() {
        return this.isPlacementActive;
    }

    public void setIsPlacementActive(Boolean isPlacementActive) {
        this.isPlacementActive = isPlacementActive;
    }

}