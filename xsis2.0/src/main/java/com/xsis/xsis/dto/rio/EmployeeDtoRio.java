package com.xsis.xsis.dto.rio;


public class EmployeeDtoRio
{
    private Long id;
    private String name;
    private String eroemail;

    public EmployeeDtoRio() {
    }

    public EmployeeDtoRio(Long id, String name, String eroemail) {
        this.id = id;
        this.name = name;
        this.eroemail = eroemail;
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

    public String getEroemail() {
        return eroemail;
    }

    public void setEroemail(String eroemail) {
        this.eroemail = eroemail;
    }
}
