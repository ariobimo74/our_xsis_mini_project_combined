package com.xsis.xsis.model.rio;

import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;

@Entity
@Table(name = "x_placement")
public class PlacementEntityRio extends CommonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "is_placement_active", nullable = false)
    private Boolean isPlacementActive;

    public PlacementEntityRio() {
    }

    public PlacementEntityRio(Long id, Long clientId, Long employeeId, Boolean isPlacementActive)
    {
        this.id = id;
        this.clientId = clientId;
        this. employeeId = employeeId;
        this.isPlacementActive = isPlacementActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getPlacementActive() {
        return isPlacementActive;
    }

    public void setPlacementActive(Boolean placementActive) {
        isPlacementActive = placementActive;
    }
}
