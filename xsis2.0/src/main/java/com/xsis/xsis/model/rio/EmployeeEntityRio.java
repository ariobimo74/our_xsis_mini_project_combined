package com.xsis.xsis.model.rio;

import com.xsis.xsis.dto.rio.EmployeeDtoRio;
import com.xsis.xsis.models.common.CommonEntity;

import javax.persistence.*;

@SqlResultSetMapping(name = "employeeMapping", classes = {
        @ConstructorResult(targetClass = EmployeeDtoRio.class, columns = {
                @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "eroemail", type = String.class) }) })

@NamedNativeQuery(name = "EmployeeEntityRio.getAllEmployeeMapping", resultSetMapping = "employeeMapping", query = "SELECT employee.id, biodata.fullname AS name, employee.ero_email AS eroemail\n"
        + "FROM x_employee AS employee\n" + "JOIN x_biodata AS biodata\n" + "ON employee.biodata_id = biodata.id\n"
        + "AND employee.isdelete = false")

@NamedNativeQuery(name = "EmployeeEntityRio.getBioId", resultSetMapping = "employeeMapping", query = "SELECT employee.id, biodata.fullname AS name, employee.ero_email AS eroemail\n"
        + "FROM x_employee AS employee\n" + "JOIN x_biodata AS biodata\n" + "ON employee.biodata_id = biodata.id\n"
        + "AND employee.isdelete = false\n" + "AND employee.biodata_id=:biodataId")

@Entity
@Table(name = "x_employee")
public class EmployeeEntityRio extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id", nullable = false)
    private Long biodataId;

    @Column(name = "is_idle")
    private Boolean isIdle;

    @Column(name = "is_ero")
    private Boolean isEro;

    @Column(name = "is_user_client")
    private Boolean isUserClient;

    @Column(name = "ero_email")
    private String eroEmail;

    public EmployeeEntityRio() {
    }

    public EmployeeEntityRio(Long id, Long biodataId, Boolean isIdle, Boolean isEro, Boolean isUserClient,
            String eroEmail) {
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

    public Long getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public Boolean getIdle() {
        return isIdle;
    }

    public void setIdle(Boolean idle) {
        isIdle = idle;
    }

    public Boolean getEro() {
        return isEro;
    }

    public void setEro(Boolean ero) {
        isEro = ero;
    }

    public Boolean getUserClient() {
        return isUserClient;
    }

    public void setUserClient(Boolean userClient) {
        isUserClient = userClient;
    }

    public String getEroEmail() {
        return eroEmail;
    }

    public void setEroEmail(String eroEmail) {
        this.eroEmail = eroEmail;
    }
}
