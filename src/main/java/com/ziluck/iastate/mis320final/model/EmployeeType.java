package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE_TYPE", schema = "MIS320_SCHEMA")
public class EmployeeType {
    private long employeeTypeId;
    private String title;
    private String classification;
    private List<Employee> employeesByEmployeeTypeId;

    @Id
    @Column(name = "EMPLOYEE_TYPE_ID")
    public long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public EmployeeType setEmployeeTypeId(long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
        return this;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public EmployeeType setTitle(String title) {
        this.title = title;
        return this;
    }

    @Basic
    @Column(name = "CLASSIFICATION")
    public String getClassification() {
        return classification;
    }

    public EmployeeType setClassification(String classification) {
        this.classification = classification;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmployeeType that = (EmployeeType) o;

        if (employeeTypeId != that.employeeTypeId) {
            return false;
        }
        if (!Objects.equals(title, that.title)) {
            return false;
        }

        return Objects.equals(classification, that.classification);
    }

    @Override
    public int hashCode() {
        int result = (int) (employeeTypeId ^ (employeeTypeId >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (classification != null ? classification.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeeTypeByEmployeeTypeId")
    public List<Employee> getEmployeesByEmployeeTypeId() {
        return employeesByEmployeeTypeId;
    }

    public EmployeeType setEmployeesByEmployeeTypeId(List<Employee> employeesByEmployeeTypeId) {
        this.employeesByEmployeeTypeId = employeesByEmployeeTypeId;
        return this;
    }
}
