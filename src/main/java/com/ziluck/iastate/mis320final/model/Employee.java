package com.ziluck.iastate.mis320final.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE", schema = "MIS320_SCHEMA")
public class Employee extends Person {
    private long personId;
    private String ssn;
    private Date startDate;
    private Date terminationDate;
    private long employeeTypeId;
    private Long locationId;
    private Long managerId;
    private Person personByPersonId;
    private EmployeeType employeeTypeByEmployeeTypeId;
    private Location locationByLocationId;
    private Employee employeeByManagerId;
    private List<Employee> employeesByPersonId;

    @Basic
    @Column(name = "SSN")
    public String getSsn() {
        return ssn;
    }

    public Employee setSsn(String ssn) {
        this.ssn = ssn;
        return this;
    }

    @Basic
    @Column(name = "START_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public Employee setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    @Basic
    @Column(name = "TERMINATION_DATE")
    public Date getTerminationDate() {
        return terminationDate;
    }

    public Employee setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_TYPE_ID", referencedColumnName = "EMPLOYEE_TYPE_ID", nullable = false)
    public EmployeeType getEmployeeTypeByEmployeeTypeId() {
        return employeeTypeByEmployeeTypeId;
    }

    public Employee setEmployeeTypeByEmployeeTypeId(EmployeeType employeeTypeByEmployeeTypeId) {
        this.employeeTypeByEmployeeTypeId = employeeTypeByEmployeeTypeId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    public Location getLocationByLocationId() {
        return locationByLocationId;
    }

    public Employee setLocationByLocationId(Location locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "PERSON_ID")
    public Employee getEmployeeByManagerId() {
        return employeeByManagerId;
    }

    public Employee setEmployeeByManagerId(Employee employeeByManagerId) {
        this.employeeByManagerId = employeeByManagerId;
        return this;
    }

    @OneToMany(mappedBy = "employeeByManagerId")
    public List<Employee> getEmployeesByPersonId() {
        return employeesByPersonId;
    }

    public Employee setEmployeesByPersonId(List<Employee> employeesByPersonId) {
        this.employeesByPersonId = employeesByPersonId;
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

        Employee that = (Employee) o;

        if (personId != that.personId) {
            return false;
        }
        if (employeeTypeId != that.employeeTypeId) {
            return false;
        }
        if (!Objects.equals(ssn, that.ssn)) {
            return false;
        }
        if (!Objects.equals(startDate, that.startDate)) {
            return false;
        }
        if (!Objects.equals(terminationDate, that.terminationDate)) {
            return false;
        }
        if (!Objects.equals(locationId, that.locationId)) {
            return false;
        }

        return Objects.equals(managerId, that.managerId);
    }

    @Override
    public int hashCode() {
        int result = (int) (personId ^ (personId >>> 32));
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (terminationDate != null ? terminationDate.hashCode() : 0);
        result = 31 * result + (int) (employeeTypeId ^ (employeeTypeId >>> 32));
        result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        return result;
    }
}
