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
@Table(name = "LOCATION", schema = "MIS320_SCHEMA")
public class Location {
    private long locationId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String phoneExt;
    private long squareFeet;
    private long roomCount;
    private List<Employee> employeesByLocationId;
    private List<Room> roomsByLocationId;

    @Id
    @Column(name = "LOCATION_ID")
    public long getLocationId() {
        return locationId;
    }

    public Location setLocationId(long locationId) {
        this.locationId = locationId;
        return this;
    }

    @Basic
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public Location setStreet(String street) {
        this.street = street;
        return this;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public Location setCity(String city) {
        this.city = city;
        return this;
    }

    @Basic
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public Location setState(String state) {
        this.state = state;
        return this;
    }

    @Basic
    @Column(name = "ZIP_CODE")
    public String getZipCode() {
        return zipCode;
    }

    public Location setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public Location setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Basic
    @Column(name = "PHONE_EXT")
    public String getPhoneExt() {
        return phoneExt;
    }

    public Location setPhoneExt(String phoneExt) {
        this.phoneExt = phoneExt;
        return this;
    }

    @Basic
    @Column(name = "SQUARE_FEET")
    public long getSquareFeet() {
        return squareFeet;
    }

    public Location setSquareFeet(long squareFeet) {
        this.squareFeet = squareFeet;
        return this;
    }

    @Basic
    @Column(name = "ROOM_COUNT")
    public long getRoomCount() {
        return roomCount;
    }

    public Location setRoomCount(long roomCount) {
        this.roomCount = roomCount;
        return this;
    }

    @OneToMany(mappedBy = "locationByLocationId")
    public List<Employee> getEmployeesByLocationId() {
        return employeesByLocationId;
    }

    public Location setEmployeesByLocationId(List<Employee> employeesByLocationId) {
        this.employeesByLocationId = employeesByLocationId;
        return this;
    }

    @OneToMany(mappedBy = "locationByLocationId")
    public List<Room> getRoomsByLocationId() {
        return roomsByLocationId;
    }

    public Location setRoomsByLocationId(List<Room> roomsByLocationId) {
        this.roomsByLocationId = roomsByLocationId;
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

        Location that = (Location) o;

        if (locationId != that.locationId) {
            return false;
        }
        if (squareFeet != that.squareFeet) {
            return false;
        }
        if (roomCount != that.roomCount) {
            return false;
        }
        if (!Objects.equals(street, that.street)) {
            return false;
        }
        if (!Objects.equals(city, that.city)) {
            return false;
        }
        if (!Objects.equals(state, that.state)) {
            return false;
        }
        if (!Objects.equals(zipCode, that.zipCode)) {
            return false;
        }
        if (!Objects.equals(phone, that.phone)) {
            return false;
        }
        return Objects.equals(phoneExt, that.phoneExt);
    }

    @Override
    public int hashCode() {
        int result = (int) (locationId ^ (locationId >>> 32));
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (phoneExt != null ? phoneExt.hashCode() : 0);
        result = 31 * result + (int) (squareFeet ^ (squareFeet >>> 32));
        result = 31 * result + (int) (roomCount ^ (roomCount >>> 32));
        return result;
    }
}
