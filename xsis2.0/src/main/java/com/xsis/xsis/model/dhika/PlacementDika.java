package com.xsis.xsis.model.dhika;

import javax.persistence.*;

import com.xsis.xsis.models.common.CommonEntity;

/**
 * Placement
 */
@Entity
@Table(name = "x_placement")
public class PlacementDika extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private ClientDika clientId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private EmployeeDika employeeId;

    @Column(name = "is_placement_active", nullable = false)
    private Boolean isPlacementActive;

    public PlacementDika() {

    }

    public PlacementDika(Long id, ClientDika clientId, EmployeeDika employeeId, Boolean isPlacementActive) {
        this.id = id;
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.isPlacementActive = isPlacementActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientDika getClientId() {
        return clientId;
    }

    public void setClientId(ClientDika clientId) {
        this.clientId = clientId;
    }

    public EmployeeDika getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeDika employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getIsPlacementActive() {
        return isPlacementActive;
    }

    public void setIsPlacementActive(Boolean isPlacementActive) {
        this.isPlacementActive = isPlacementActive;
    }

}