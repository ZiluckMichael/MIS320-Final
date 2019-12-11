package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE", schema = "MIS320_SCHEMA")
public class Employee {
    private long personId;
    private String ssn;
    private Time startDate;
    private Time terminationDate;
    private long employeeTypeId;
    private Long locationId;
    private Long managerId;
    private Person personByPersonId;
    private EmployeeType employeeTypeByEmployeeTypeId;
    private Location locationByLocationId;
    private Employee employeeByManagerId;
    private List<Employee> employeesByPersonId;

    @Id
    @Column(name = "PERSON_ID")
    public long getPersonId() {
        return personId;
    }

    public Employee setPersonId(long personId) {
        this.personId = personId;
        return this;
    }

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
    public Time getStartDate() {
        return startDate;
    }

    public Employee setStartDate(Time startDate) {
        this.startDate = startDate;
        return this;
    }

    @Basic
    @Column(name = "TERMINATION_DATE")
    public Time getTerminationDate() {
        return terminationDate;
    }

    public Employee setTerminationDate(Time terminationDate) {
        this.terminationDate = terminationDate;
        return this;
    }

    @Basic
    @Column(name = "EMPLOYEE_TYPE_ID")
    public long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public Employee setEmployeeTypeId(long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
        return this;
    }

    @Basic
    @Column(name = "LOCATION_ID")
    public Long getLocationId() {
        return locationId;
    }

    public Employee setLocationId(Long locationId) {
        this.locationId = locationId;
        return this;
    }

    @Basic
    @Column(name = "MANAGER_ID")
    public Long getManagerId() {
        return managerId;
    }

    public Employee setManagerId(Long managerId) {
        this.managerId = managerId;
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

    @OneToOne
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID", nullable = false)
    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public Employee setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
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
}
