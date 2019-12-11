package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "PERSON", schema = "MIS320_SCHEMA")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class Person {
    private long personId;
    private String firstName;
    private String lastName;
    private Time birthDate;
    private String phone;
    private String phoneExt;

    @Id
    @Column(name = "PERSON_ID")
    public long getPersonId() {
        return personId;
    }

    public Person setPersonId(long personId) {
        this.personId = personId;
        return this;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Basic
    @Column(name = "BIRTH_DATE")
    public Time getBirthDate() {
        return birthDate;
    }

    public Person setBirthDate(Time birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Basic
    @Column(name = "PHONE_EXT")
    public String getPhoneExt() {
        return phoneExt;
    }

    public Person setPhoneExt(String phoneExt) {
        this.phoneExt = phoneExt;
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

        Person person = (Person) o;

        if (personId != person.personId) {
            return false;
        }
        if (!Objects.equals(firstName, person.firstName)) {
            return false;
        }
        if (!Objects.equals(lastName, person.lastName)) {
            return false;
        }
        if (!Objects.equals(birthDate, person.birthDate)) {
            return false;
        }
        if (!Objects.equals(phone, person.phone)) {
            return false;
        }

        return Objects.equals(phoneExt, person.phoneExt);
    }

    @Override
    public int hashCode() {
        int result = (int) (personId ^ (personId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (phoneExt != null ? phoneExt.hashCode() : 0);
        return result;
    }
}
