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
@Table(name = "SERVICE", schema = "MIS320_SCHEMA")
public class Service {
    private long serviceId;
    private String name;
    private String description;
    private long cost;
    private List<ReservationService> reservationServicesByServiceId;

    @Id
    @Column(name = "SERVICE_ID")
    public long getServiceId() {
        return serviceId;
    }

    public Service setServiceId(long serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public Service setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public Service setDescription(String description) {
        this.description = description;
        return this;
    }

    @Basic
    @Column(name = "COST")
    public long getCost() {
        return cost;
    }

    public Service setCost(long cost) {
        this.cost = cost;
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

        Service that = (Service) o;

        if (serviceId != that.serviceId) {
            return false;
        }
        if (cost != that.cost) {
            return false;
        }
        if (!Objects.equals(name, that.name)) {
            return false;
        }
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = (int) (serviceId ^ (serviceId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (cost ^ (cost >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public List<ReservationService> getReservationServicesByServiceId() {
        return reservationServicesByServiceId;
    }

    public Service setReservationServicesByServiceId(List<ReservationService> reservationServicesByServiceId) {
        this.reservationServicesByServiceId = reservationServicesByServiceId;
        return this;
    }
}
